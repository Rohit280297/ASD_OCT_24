public class MergeSort {

    public static int merge(int[] arr, int left, int mid, int high)
    {
        int m = mid - left + 1; // length of left array.
        int n = high - mid; // length of right array.
        int[] leftArr = new int[m]; //  { left - mid};
        int[] rightArr = new int[n]; // {mid+1 - high}
        int count = 0;

        // copting the elements to the left array.
        for(int i=0;i<m;i++) 
        {
            leftArr[i] = arr[left+i];
        }

        // copying the elements to the right array.
        for(int j=0;j<n;j++)
        {
            rightArr[j] = arr[mid+1+j];
        }

        int i = 0; // pointer to left array.
        int j = 0; // pointer to right array.
        int k = left; // start index of arr.

        while(i < m && j < n)
        {
            if(leftArr[i] <= rightArr[j])
            {
                arr[k++] = leftArr[i++];
            }
            else
            {
                arr[k++] = rightArr[j++];
                count += (m - i);
            }
        }

        while(i < m)
        {
            arr[k++] = leftArr[i++];
        }

        while(j<n)
        {
            arr[k++] = rightArr[j++];
        }

        return count;
    }

    static int mergeSort(int[] arr, int left, int right)
    {
        int count = 0;
        if(left < right)
        {
            int mid = left + (right - left)/2;
            count += mergeSort(arr, left, mid); // sorting the left subarray. ( from left - mid)
            count += mergeSort(arr, mid+1, right); // sorting the right subarray ( from mid+1 - right);
            count += merge(arr, left, mid, right);
        }

        return count;
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
        int invCount = mergeSort(arr, 0, arr.length-1);
        printArray(arr);
        System.out.println(invCount);
    }
}
