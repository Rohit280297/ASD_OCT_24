import java.util.*;

public class SmallerOnRight {

    public static int findIndex(int k, ArrayList<Integer> list)
    {
        int n = list.size(); // arr.length
        if(k < list.get(0))
            return 0;
        else if(k > list.get(n-1))
            return n;
        int left = 0;
        int right = n-1;
        int index = 0;

        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(list.get(mid) < k) {
                left = mid+1;
            }  
            else{
                index = mid;
                right = mid - 1;
            }     
        }
        return index;
    }

    public static void countOfSmallerOnRight(int[] arr)
    {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res,0);
        ArrayList<Integer> sortedList = new ArrayList<>();
        res[n-1] = 0;
        sortedList.add(arr[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            int index  = findIndex(arr[i], sortedList);
            res[i] = index;
            sortedList.add(index, arr[i]); // add(index, value);
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        countOfSmallerOnRight(arr);
    }
}
