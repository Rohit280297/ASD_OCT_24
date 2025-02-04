import java.util.*;

public class NextLargerPermutation {
    static void nextLarger(int[] arr)
    {
        int n = arr.length;
        int i = n-2;
        while(i >= 0)
        {
            if(arr[i] < arr[i+1])
                break;
            i--;
        }

        if(i != -1)
        {
            int j =  n-1;
            while(arr[j] <= arr[i]) // find the rightmost number greater than nums[i];
                j--;
            
            // swap(arr, i , j);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // reverse the array from i+1 to n-1.
        int x = i+1;
        int y = n-1;
        while(x < y)
        {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
    }

    static String longestSubsequenceWithDistinctChars(String s)
    {
        String res = "";
        int[] freq = new int[26];
        boolean[] included = new boolean[26];
        Arrays.fill(included,false);
        // store the frequency.
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0;i< s.length();i++)
        {
            char ch = s.charAt(i);

            // check if the character is already included.
            if(included[ch - 'a'])
                continue;
            //reduce the frequency.
            freq[ch - 'a']--;
            // mark it as included.
            included[ch - 'a'] = true;

            while(!st.isEmpty() && st.peek() > ch && freq[st.peek()- 'a'] > 0)
            {
                int poppedElement = st.pop();
                included[poppedElement - 'a'] = false;
            }
            st.push(ch);
        }

        while(!st.isEmpty())
        {
            res = st.pop() + res;
        }

        return res;
    }

    // sum1 = totalSum.
    // sum2 = 0
    public static int minDiff(int[] arr, int n, int sum1, int sum2)
    {
        if(n == 0)
            return Math.abs(sum1 - sum2);
        
        return Math.min(minDiff(arr,n-1, sum1, sum2), minDiff(arr, n-1, sum1-arr[n-1], sum2+arr[n-1]));
    }
    public static void main(String[] args)
    {
        // int[] nums = {4,3,2,1};
        // nextLarger(nums);
        // for(int d : nums)
        //     System.out.print(d+" ");
        // System.out.println();
        String s = "bcadbc";
        System.out.println(longestSubsequenceWithDistinctChars(s));
    }

}
