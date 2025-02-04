class QuickSort {

    public static int partition(int[] arr, int left, int right)
    {
        int pivot = right;
        int i = left-1;
        for(int j=left;j<pivot;j++)
        {
            if(arr[j] < arr[pivot])
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void quickSort(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int pIndex = partition(arr, left, right);
            quickSort(arr, left, pIndex-1);
            quickSort(arr, pIndex+1, right);
        }
    }

    static void printArray(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] arr = {5,1,8,3,4};
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}