public class SubsetPartition {
    public static int partition(int[] arr,int currIndex, int sum1, int sum2)
    {
        if(currIndex == arr.length)
            return Math.abs(sum1-sum2);
        return Math.min(partition(arr, currIndex+1, sum1, sum2), partition(arr, currIndex+1, sum1-arr[currIndex], sum2+arr[currIndex]));
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        int sum1 = 0;
        for(int i=0;i<arr.length;i++)
        sum1 += arr[i];
        int minDiff = partition(arr,0,sum1, 0);
        System.out.println(minDiff);
    }
}
