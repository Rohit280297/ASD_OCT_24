import java.util.*;

public class NextLargerElement {
    
    static void nextLargerOnRight(int[] nums, int[] res)
    {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        res[n-1] = 0;
        st.push(nums[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek() < nums[i])
            {
                st.pop();
            }

            if(st.isEmpty())
                res[i] = 0;
            else
                res[i] = st.peek();
            
                st.push(nums[i]);
        }
    }

    static void printArr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] nums = {5,1,8,3,4,7};
        int[] res = new int[nums.length];
        nextLargerOnRight(nums, res);
        printArr(nums);
        printArr(res);
    }
}
