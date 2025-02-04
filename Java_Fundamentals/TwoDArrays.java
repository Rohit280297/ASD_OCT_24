public class TwoDArrays {
    public static void main(String[] args) {
        // dataType[][] name = new dataType[r][c];
        int[][] arr = new int[3][4];
        // for(int i=0;i<3;i++)
        // {
        //     for(int j=0;j<4;j++)
        //     {
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // arr[0][3] = 5;

        // System.out.println("************");

        // for(int i=0;i<3;i++)
        // {
        //     for(int j=0;j<4;j++)
        //     {
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int[][] arr2 = new int[3][];
        int[] a = {5,6,7,8,9};
        int[] b = {2,3};
        int[] c = {7,56,90};
        
        arr2[0] = a; // assigns a as the 0th row of arr2.
        arr2[1] = b; // assigns b as the 1st row of arr2.
        arr2[2] = c;

        System.out.println(arr2.length);
        System.out.println(arr2[0].length); // no. of elements in the 0th row.


    }
}
