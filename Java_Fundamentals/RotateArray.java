
public class RotateArray {

    public static void reverse(int[] arr, int start, int end)
    {
        int i = start;
        int j = end;
        while(i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void rotateArray(int[] arr, int k)
    {
        int n = arr.length ;
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);

        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        int k = 3;
        int[] arr = {1,2,3,4,5,6,7};
        rotateArray(arr,k);

    }
}
