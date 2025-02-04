import java.util.*;

public class BinarySearch {
    public static int findIndexOf(int[] arr, int target)
    {
        int left = 0;
        int right = arr.length-1;
        while(left < right)
        {
            int mid = (left + right) /2;
            if(arr[mid] < target)
                left = mid+1;
            else {
                right = mid;
            }
            
        }

        return right;
    }
    public static int binarySearch(int[] arr, int target)
    {
        // implement binary search here.
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                right = mid -1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,10,14};
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(findIndexOf(arr, target));
    }
}
