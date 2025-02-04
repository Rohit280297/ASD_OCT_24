
public class StringPermutations {

    public static int atoi(String s)
    {
        int res = 0;
        boolean isNegative = false;

        if(s.charAt(0) == '-'){
            s = s.substring(1);
            isNegative = true;
        }
        
        for(int i=0;i<s.length();i++)
        {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
        }

        return isNegative ? res * (-1) : res;
    }

    public static void getPermutations(String s, String res) {

        if(s.length() == 0)
        {
            System.out.print(res+ " ");
        }

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            String rem = s.substring(0, i) + s.substring(i+1);

            getPermutations(rem, res + ch);
        }
    }
    public static void main(String[] args)
    {
        String s = "abc";
        String ans = "";
        getSubSequence(s, ans);
        // System.out.println(ans);

    }

    public static void generatePermutations(String s, String curr)
    {
        if(s.length() == 0)
            System.out.print(curr+" ");
        else
        {
            for(int i=0;i<s.length();i++)
            {
                String rem = s.substring(0, i) + s.substring(i+1);
                generatePermutations(rem, curr+s.charAt(i));
            }
        }
    }

    public static void getSubSequence(String s, String curr)
    {
        if(s.length() == 0)
            System.out.print(curr+" ");
        
        else
        {
            getSubSequence(s.substring(0, s.length()-1), curr+s.charAt(s.length()-1));
            getSubSequence(s.substring(0, s.length()-1), curr);
        }
    }
}
