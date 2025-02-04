public class Functions {
    static void decimalToBinary(int n){
        String res = "";
       while(n > 0) {
        res = res + n%2;
        n/=2; // n = n/2;
       }
       
       for(int i=res.length()-1;i>=0;i--){
            System.out.print(res.charAt(i));
       }

       System.out.println();
    }

    static void binaryToDecimal(String binaryString) { // 101
        // 101 = 1 * 2^2 + 0 * 2^1 + 1* 2^0

        int n = 0;
        int currPow = 0;
        for(int i=binaryString.length()-1;i>=0;i--) {
            n = n + (int)((binaryString.charAt(i) - '0') * Math.pow(2, currPow));
            currPow++;
        }

        System.out.println(n);
    }

    static long fibonacci(int n) {
        if( n == 0)
            return 0;
        if(n == 1 || n == 2) 
            return 1;
        
        long res = 0;
        long a = 1;
        long b = 1;
        while(n > 2) {
            res = a + b; // 2 3
            a = b; // 1
            b = res; // 2
            n--; // 3
        }

        return res;
    }

    static long fibonacciRec(int n){

        if(n == 0)
            return 0;
        if(n == 1 || n==2)
            return 1;
        
        return fibonacciRec(n-1) + fibonacciRec((n-2));
    }

    static double celciusToFarenheit(double temperature) {
        // F = (9/5)* C + 32
        return (9.0/5)* temperature + 32;
    }

    static double farenHeitToCelcius(double temperature) {
        return (temperature - 32) * (5.0/9);
    }

    static void temperatureTable(double start, double end, double step) {
        double currVal = start;
        while(currVal <= end) {
            System.out.println(currVal+" -> "+ farenHeitToCelcius(currVal));
            currVal += step;
        }
    }

    static int factorial(int x)
    {
        if(x == 0 || x == 1)
            return 1;
        return x * factorial(x-1);
    }

    static int nCr(int n, int r)
    {
        return factorial(n) / (factorial(r) * factorial(n-r));
    }

    static void pascalTriangleRow(int row) 
    {
        for(int i=0;i<= row;i++)
        {
            System.out.print(nCr(row, i)+" ");
        }
    }

    public static void main(String[] args) {
        // decimalToBinary(5);
        // binaryToDecimal("101");
        // long res = fibonacciRec(6);
        // System.out.println(res);
        // temperatureTable(0, 100, 20);
        pascalTriangleRow(3);
    }



}