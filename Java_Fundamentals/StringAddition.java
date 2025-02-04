public class StringAddition {

    public static String findSum(String a, String b)
    {
        String sum = "";
        
        int n1 = a.length();
        int n2 = b.length();

        int i = n1-1;
        int j = n2-1;
        int carry = 0;

        while(i >= 0 && j >= 0)
        {
            int d1 = a.charAt(i) - '0';
            int d2 = b.charAt(j) - '0';

            int s = d1+d2+carry;
            sum = s%10 + sum;
            carry = s/10;
            i--;
            j--;
        }

        while(i >= 0)
        {
            int d1 = a.charAt(i) - '0';
            int s = d1 + carry;
            sum = s%10 + sum;
            carry = s/10;
            i--;
        }

        while(j >= 0)
        {
            int d1 = b.charAt(j) - '0';
            int s = d1 + carry;
            sum = s%10 + sum;
            carry = s/10;
            j--;
        }

        if(carry != 0)
            sum = carry + sum;
        return sum;
    }
    public static void main(String[] args)
    {
        String s1 = "12485858759";
        String s2 = "9838584848";

        String sum = findSum(s1,s2);
        System.out.println(sum);
    }
}
