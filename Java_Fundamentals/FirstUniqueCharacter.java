import java.util.*;

public class FirstUniqueCharacter {

    public static int findIndexOfFirstUnique(String s)
    {
        int[] freq = new int[26];
        int index = -1;
        for(int i=0;i<s.length();i++)
        {   
            int x = s.charAt(i) - 'a';
            freq[x]++;
        }

        for(int i=0;i<s.length();i++)
        {
            int x = s.charAt(i) - 'a';
            if(freq[x] == 1)
            {
                index = i;
                break;
            }
        }

        return index;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int index = findIndexOfFirstUnique(s);
        System.out.println(index);
    }
}
