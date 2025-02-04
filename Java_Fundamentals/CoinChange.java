public class CoinChange {

    public static int countWays(int n, int[] coins, int k)
    {
        if(n == 0)
            return 1;
        if(k == 0 || n < 0)
            return 0;
        return countWays(n-coins[k-1], coins, k) + countWays(n, coins, k-1);        
    }
    public static void main(String[] args){
        int n = 4;
        int[] coins = {1,2,3};
        // n = the sum that is to be achieved.
        // coins = the type of denominations.
        // k = the count of coins array.
        int count = countWays(n,coins,coins.length);
        System.out.println(count);
    }
}
