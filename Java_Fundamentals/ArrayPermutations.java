import java.util.*;

public class ArrayPermutations {

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void generatePermutations(int[] arr,int index, ArrayList<ArrayList<Integer>> result)
    {
        if(index  == arr.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : arr)
            {
                list.add(num);
            }
            result.add(list);
        }

        for(int i=index;i<arr.length;i++)
        {
            swap(arr, index, i);
            generatePermutations(arr, index+1, result);
            swap(arr, index, i);
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3, 4};
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        generatePermutations(arr,0, result);

        System.out.println(result);
    }
}
