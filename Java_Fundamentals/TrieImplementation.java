import java.util.ArrayList;

class Node{
    Node[] children;
    boolean endOfWord;
    int prefixCount;

    Node()
    {
        children = new Node[26];
        endOfWord = false;
        prefixCount = 0;
    }
}

class Trie{

    Node root;

    Trie()
    {
        root = new Node();
    }

    void insert(String str)
    {
        Node curr = this.root;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(curr.children[ch-'a'] == null)
            {
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch- 'a'];
            curr.prefixCount++;
        }
        curr.endOfWord = true;
    }

    boolean search(String word){

        Node curr = this.root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.endOfWord;
    }

    void printWords(Node root, String curr, ArrayList<String> words)
    {
        if(root == null)
            return;
        // curr = "xyzb" , "xyzd"
        for(int i=0;i<root.children.length;i++)
        {
            if(root.children[i] != null) // i == 1 -> b 
            {
                String newStr = new String(curr);
                newStr += (char)(i + 'a');
                if(root.children[i].endOfWord)
                {
                    words.add(newStr);
                }
                printWords(root.children[i], newStr, words);
            }
        }
    }

    int startsWith(String prefix)
    {
        Node curr = this.root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null)
                return 0;
            curr = curr.children[ch - 'a'];
        }
        return curr.prefixCount;
    }

    void startsWith(String prefix, ArrayList<String> words)
    {
        Node curr = this.root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null)
                return;
            curr = curr.children[ch - 'a'];
        }
        if(curr.endOfWord)
            words.add(prefix);
        printWords(curr, prefix, words);
    }

    void delete(String word)
    {
        Node curr = this.root;
        if(this.root == null)
            return;
        
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] != null)
            {
                if(i == (word.length() - 1)){
                    curr.children[ch - 'a'].endOfWord = false;
                }
                curr = curr.children[ch- 'a'];
            }
            else
                return;
        }
    }
}

public class TrieImplementation {
    public static void main(String[] args)
    {
        Trie t = new Trie();
        t.insert("fat");
        t.insert("abc");
        t.insert("cabins");
        t.insert("abd");
        t.insert("cab");
        t.insert("cabs");
        t.insert("cabin");
        
        System.out.println(t.search("fat"));
        ArrayList<String> words = new ArrayList<>();
        // t.printWords(t.root, "", words);
        // System.out.println(words);
        // t.delete("cabin");
        System.out.println(t.search("cabin"));
        System.out.println(t.search("cabins"));
        System.out.println(t.startsWith("ab"));
        t.startsWith("a", words);
        System.out.println(words);
    }
}
