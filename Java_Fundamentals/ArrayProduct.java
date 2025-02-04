public class ArrayProduct {

    public static void arrayProduct(int[] arr)
    {
        int n = arr.length;
        int[] res = new int[n];
        int leftProd = 1;
        for(int i=0;i<n;i++)
        {
            res[i] = leftProd;
            leftProd *= arr[i];
        }

        int rightProd = 1;
        for(int i=n-1;i>=0;i--)
        {
            res[i] = res[i] * rightProd;
            rightProd *= arr[i];
        }

        for(int i=0;i<n;i++)
            System.out.print(res[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        arrayProduct(arr);
    }
}
