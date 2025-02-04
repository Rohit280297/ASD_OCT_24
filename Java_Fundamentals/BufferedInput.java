// Importing the BufferedReader class.
import java.io.*;

public class BufferedInput {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // takes an object of InputStreamReader.
        int num = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String[] nums = line.split(" "); // "4 6 2 3 1" => "4" | "6" | "2" | "3" | "1"
        int[] numbers = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            numbers[i] = Integer.parseInt(nums[i]);
        

    }
}

// 1. Importing.
// 2. object creation.
// 3. throwing the exception.
// 4. Taking input

// Disadvantages : parse the input.
// Advantage : it becomes faster.