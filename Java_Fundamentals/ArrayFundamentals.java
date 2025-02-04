import java.util.*;

public class ArrayFundamentals {

    public static void modifyInt(int n)
    {
        n = 2*n;
        System.out.println(n); // 10
    }

    public static void printArray(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }

        System.out.println();
    }

    public static void modifyArray(int[] nums) 
    {
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = nums[i] * 2;
        }

        printArray(nums);
    }

    public static int linearSearch(int[] arr, int target) {
        int index = -1; // the index of the target element.
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == target){
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        // dataType[] nameOfArray = new dataType[length];
        //dataType nameOfArray[] = new dataType[length];

        int[] numbers = new int[7];
        int n = numbers.length; // nameOfArray.length;

        Scanner sc = new Scanner(System.in);

        for(int i=0;i<n;i++)
        {
            numbers[i] = sc.nextInt();
        }

        printArray(numbers);

        int target = sc.nextInt();

        int foundIndex = linearSearch(numbers, target);
        System.out.println(foundIndex);



        
       

    }
}
