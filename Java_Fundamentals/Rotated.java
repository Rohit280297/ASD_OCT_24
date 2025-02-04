public class Rotated {

    public static int find(int[] arr, int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[low] <= arr[mid])
            {
                // left sorted array.
                if(arr[low] <= target && target <= arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else
            {
                if(arr[mid] <= target && target <= arr[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2,3,4};
        int target = 4;

        System.out.println(find(arr, target));
    }
}
