public class CountAndSay {

    public static String countAndSay(String s) // "1211"
    {
        String res = ""; // ""
        char ch = s.charAt(0); // '2' //  '1'
        int count = 0; // 0
        int i = 0; // 0 // 1
        while(i < s.length())
        {
            if(s.charAt(i) == ch)
                count++; // 1
            else
            {
                res += "" + count + ch; // res = "" + 12
                count = 1;
                ch = s.charAt(i); // ch = '1'
            }
            i++; // 2
        }
        res += "" + count + ch; // "12" + 1 + 1 => '1211'
        return res;
    }
    public static void main(String[] args) {
        int n =5;
        String currRes = "1";
        for(int i=2;i<=n;i++)
        {
            currRes = countAndSay(currRes);
        }

        System.out.println(currRes);
    }
}
