import java.util.*;

public class BinaryTreePractise {

    static void printDFS(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        st.push(0); // push the index 0 to the stack.
        while(!st.isEmpty())
        {
            int popped = st.pop();
            System.out.print(arr[popped]+" ");
            int left = 2*popped+1;
            int right = 2*popped+2;

            if(right < arr.length && arr[right] !=-1 )
                st.push(right);
            if(left < arr.length && arr[left] !=-1 )
                st.push(left);
        }

        System.out.println();
    }

    static Node LCA(Node root, int val1, int val2)
    {
        if(root == null)
            return null;

        if(root.data == val1 || root.data == val2)
            return root;
        
        Node leftAncestor = LCA(root.left, val1, val2); // not null.
        Node rightAncestor = LCA(root.right, val1, val2);
    
        if(leftAncestor != null && rightAncestor != null)
            return root;
        
        if(leftAncestor != null)
            return leftAncestor; 
        else    
            return rightAncestor;
    }

    public static void main(String[] args)
    {
        int[] arr = {5,1,8,3,4,2};
        printDFS(arr);
    }
}
