public class Recursion {

    public static int sumOfNaturalNumbers(int n) {
        if(n == 1)
            return 1;
        return n + sumOfNaturalNumbers(n-1);
    }

    public static long factorial(int n)
    {
        if(n == 0)
            return 1;
        return n * factorial(n-1);
    }

    public static void printN(int n)
    {
        // 1 2 3 4 5 6 .... n
        // if n = 5, 1 2 3 4 5
        if(n == 1)
            System.out.print(1+" ");
        else
        {
            System.out.print(n+" ");
            printN(n-1);
        }
    }

    public static int towerOfHanoi(int n)
    {
        if(n==1)
            return 1; // base condition.
        return 2* towerOfHanoi(n-1) + 1; // recursive formula.
    }

    public static int findMinimum(int[] arr, int n)
    {
        if(n == 1)
            return arr[0];
        return Math.min(arr[n-1], findMinimum(arr, n-1));
    }

    public static long power(int a, int b)
    {
        if(a == 0)
            return 0;
        if(b == 0)
            return 1;
        if(b == 1)
            return a;
        
        return power(a, b/2) * power(a, b-b/2);
    }

    public static int sumOfDigits(int n)
    {
        if(n <= 9)
            return n;
        return sumOfDigits(n%10 + sumOfDigits(n/10));
    }
    public static void main(String[] args)
    {
        // System.out.println(sumOfNaturalNumbers(5));
        // System.out.println(factorial(5));
        // printN(5);
        // System.out.println(towerOfHanoi(4));
        // int[] arr = {5,1,8,3,4,12};
        // System.out.println(findMinimum(arr, arr.length));
        // System.out.println(power(3,4));
        System.out.println(sumOfDigits(581234252));
    }
}
