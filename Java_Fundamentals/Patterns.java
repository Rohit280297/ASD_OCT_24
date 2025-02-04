public class Patterns
{
    static {
        System.out.println("Hello from static block");
    }
    
    static int factorial(int n)
    {
        if(n == 0)
            return 1;
        return n * factorial(n-1); /// n! = n * (n-1)!
    }

    static int nCr(int n, int r)
    {
        return factorial(n)/(factorial(r) * factorial(n-r));
    }

    public static void pascalTriangle(int n)
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print(nCr(i,j)+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        // // for(int i=1;i<=n;i++){
        // //     for(int j= 1;j<=i;j++)
        // //     {
        // //         System.out.print("* ");
        // //     }
        // //     System.out.println();
        // // }

        // for(int i=1;i<=n;i++)
        // {
        //     for(int j= 1;j<=n;j++)
        //     {
        //         if(j < i)
        //         {
        //             System.out.print(" ");
        //         }else{
        //             System.out.print("*");
        //         }
        //     }
        //     System.out.println();
        // }

        // pascalTriangle(n);


    }
}