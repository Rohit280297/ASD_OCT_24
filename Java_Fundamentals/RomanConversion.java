import java.util.*;
public class RomanConversion {

    public static String convertToRoman(int n)
    {
        String res = "";
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M", "CM", "D", "CD","C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i= 0; // 0 1 2 3 4 5 6 7 8 9
        while(n > 0) // 49 9
        {
            if(n >= values[i])
            {
                res += symbols[i]; // XLIX
                n-=values[i]; // 0
            }
            else
                i++;
        }
        return res;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String roman = convertToRoman(n);
        System.out.println(roman);
    }
}
