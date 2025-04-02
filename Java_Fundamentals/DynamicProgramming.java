import java.util.Arrays;

class DP{
    static int[] dp;
    DP()
    {
        dp = new int[1001];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
    }
    int fibonacci(int n){
        System.out.println("Computing value for : "+ n);
        if(n < 0)
            return 0;
        if(n == 0 || n==1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    int fibonacciUsingMemoization(int n)
    {
        if(dp[n] != -1)
            return dp[n];
        else{
            System.out.println("Computation for : "+ n);
            dp[n] = fibonacciUsingMemoization(n-1) + fibonacciUsingMemoization(n-2);
            return dp[n];
        }
    }
    int fibonacciUsingTabulation(int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
        {
            dp[i] = dp[i-1]+ dp[i-2];
        }

        return dp[n];
    }

    // 0-1 knapsack problem.
    int maxProfit(int[] weights, int[] profit, int n, int W)
    {
        if(n == 0)
            return 0;
        
        if(n > 0 && weights[n-1] > W)
            return maxProfit(weights, profit, n-1,W);

        if(W <= 0)
            return 0;
        
        return Math.max(profit[n-1] + maxProfit(weights, profit, n-1, W - weights[n-1]), maxProfit(weights,profit, n-1, W));
    }

    int maxProfitUsingTabulation(int[] weights, int[] profits, int W)
    {
        int n = weights.length;

        int[][] table = new int[n+1][W+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(weights[i-1] <= j)
                {
                    // exclude current item.
                    int val1 = table[i-1][j];
                    // include current item.
                    int val2 = profits[i-1] + table[i-1][j- weights[i-1]];
                    table[i][j] = Math.max(val1, val2);
                }
                else{
                    table[i][j] = table[i-1][j];
                }
            }
        }
        return table[n][W];
    }

    // int maxProfitUsingMemoization(int[] weights, int[] profits, int W)
    // {

    // }
}

public class DynamicProgramming {
    public static void main(String[] args) {
        DP obj = new DP();
        int n = 5;
        System.out.println(obj.fibonacciUsingMemoization(n));
        System.out.println(obj.fibonacciUsingTabulation(n));
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(obj.dp[i]+" ");
        // }
        // System.out.println();
        int[] weights = {2,1,5,3};
        int[] profit = {300,200,400,500};
        n = weights.length;
        int W = 10;
        System.out.println(obj.maxProfit(weights, profit, n, W));
        System.out.println(obj.maxProfitUsingTabulation(weights, profit, W));
    }
}
