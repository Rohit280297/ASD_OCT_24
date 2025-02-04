public class InversionCount {

    public static int inversionCount(int[] arr)
    {
        int count = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr = {5,1,8,3,4};
        int iCount = inversionCount(arr);
        System.out.println(iCount);
    }
}
