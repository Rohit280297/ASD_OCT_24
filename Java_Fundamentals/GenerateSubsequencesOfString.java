public class GenerateSubsequencesOfString {

    static void printSubsequences(String s, int i, String curr)
    {
        if(i== s.length())
            System.out.print(curr+" ");
        else {
            printSubsequences(s, i+1, curr+s.charAt(i));
            printSubsequences(s, i+1, curr);
        }
    }

    static void printPermutations(String s, String curr)
    {
        if(s.length() == 0){
            System.out.print(curr+" ");
        }

        for(int j=0;j<s.length();j++)
        {
            String rem = s.substring(0, j) + s.substring(j+1);
            printPermutations(rem,curr+s.charAt(j));

        }   
    }
    public static void main(String[] args)
    {
        String s = "abc";
        printPermutations(s, "");
        System.out.println();
        printSubsequences(s, 0, "");

    }
}
