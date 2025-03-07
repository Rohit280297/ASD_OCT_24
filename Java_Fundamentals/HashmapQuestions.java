import java.util.*;

public class HashmapQuestions {
    static int[] getPairSum(int[] arr, int k)
    {
        int[] res = {-1,-1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(k- arr[i]))
            {
                res[0] = map.get(k-arr[i]);
                res[1] = i;
                break;
            }else
            {
                map.put(arr[i], i);
            }
        }
        return res;
    }

    static void printUniqueInSameOrder(String s)
    {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(freq.containsKey(s.charAt(i)))
            {
                freq.put(s.charAt(i), 1+freq.get(s.charAt(i)));
            }
            else
                freq.put(s.charAt(i), 1);
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(freq.containsKey(c))
            {
                System.out.println(c+" "+freq.get(c));
                freq.remove(c);
            }
        }
        System.out.println();
    }

    public static int longestConsecutiveSequence(int[] arr)
    {
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer x : arr)
            map.put(x, 1);
        
        for(int i=0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]-1))
            {
                int count = 1;
                int curr = arr[i]+1;
                while(map.containsKey(curr))
                {
                    count++;
                    curr = curr+1;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
    
    public static int longestSubarrayWithSumZero(int[] arr)
    {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum  =0;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];

            if(sum == 0)
                maxLen = Math.max(maxLen, i+1);

            if(map.containsKey(sum))
            {
                maxLen = Math.max(maxLen, i - map.get(sum));
            }
            else
            {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int longestSubarrayWithSum(int[] arr, int k)
    {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];

            if(sum == k)
                maxLen = i+1;
            
            if(map.containsKey(sum-k))
                maxLen = Math.max(maxLen, i - map.get(sum-k));
            else
                map.put(sum, i);

        }
        return maxLen;
    }

    public static int firstMissingPositive(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : arr)
        {
            if(x > 0)
                map.put(x, 1);
        }
        int missing = 1;
        for(int x : arr)
        {
            if(x > 0){
                if(map.containsKey(missing))
                {
                    missing++;
                }
                else
                    return missing;
            }
        }
        return missing;
    }

    static boolean subArrayWithSumDivisible(int[] arr, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];

            if(sum%k == 0 && i >= 1)
                return true;
            if(map.containsKey(sum%k))
            {
                int len = i - map.get(sum%k);
                if(len >= 2)
                    return true;
            }
            else
                map.put(sum%k, i);
        }
        return false;
    }
    public static void main(String[] args)
    {
        // int[] arr = {5,1,8,7,3,6};
        // int k = 9;
        // int[] res = getPairSum(arr, k);
        // System.out.println(res[0]+" "+res[1]);
        // printUniqueInSameOrder("bxbyazcb");

        // int[] brr = {4,5,100,2,1,8,3,6,7};
        // System.out.println(longestConsecutiveSequence(brr));
        // int[] arr = {23,2,4,6,7};
        // // System.out.println(longestSubarrayWithSum(arr, 15));
        // System.out.println(subArrayWithSumDivisible(arr, 8));

        // HashSet<Integer> set = new HashSet<>();
        // set.add(5);
        // set.add(6);
        // set.add(7);
        // set.add(7);
        // set.add(7);
        // set.add(7);
        // set.add(7);
        // set.add(7);
        // set.add(7);
        // set.add(7);
        // set.add(7);
        // set.add(5); // adds an element to the set if not present. If present, it simply ignores.
        // System.out.println(set);
        // set.remove(7); // removes an element from the set.
        // System.out.println(set);
        // System.out.println(set.contains(5));
        // System.out.println(set.size());
        // String s = "aAbcDa";
        // TreeSet<Character> st = new TreeSet<>();
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // for(int i=0;i<s.length();i++)
        //     st.add(s.charAt(i));
        // System.out.println(st);

        // LinkedHashMap<Integer, Integer> lmap = new LinkedHashMap<>();
        // LinkedHashSet<Integer> lset = new LinkedHashSet<>();

        String s = "aAbcDa";
        HashSet<Character> hset = new HashSet<>();
        TreeSet<Character> tset = new TreeSet<>();
        LinkedHashSet<Character> lset = new LinkedHashSet<>();

        for(int i=0;i<s.length();i++)
        {
            hset.add(s.charAt(i));
            tset.add(s.charAt(i));
            lset.add(s.charAt(i));
        }

        System.out.println(hset);
        System.out.println(tset);
        System.out.println(lset);
    }
}
