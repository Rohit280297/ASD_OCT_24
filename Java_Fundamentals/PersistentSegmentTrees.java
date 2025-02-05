

class Node{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
    }
}
class PersistentSegmentTree{
    Node[] versions;

    PersistentSegmentTree(int nVersions)
    {
        versions = new Node[nVersions];
        for(int i=0;i<nVersions;i++)
        {
            versions[i] = new Node(0);
        }
    }

    // sum segment tree.
    void buildTree(Node root, int[] arr, int low, int high)
    {
        if(low == high)
        {
            root.data = arr[low];
            return;
        }
        else
        {
            int mid = (low + high) /2;
            root.left = new Node(0);
            root.right = new Node(0); 
            buildTree(root.left, arr, low, mid);
            buildTree(root.right, arr, mid+1, high);
            root.data = root.left.data + root.right.data;
        }
    }

    void printTree(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        printTree(root.left);
        printTree(root.right);
    }

    void update(Node prev, Node root, int[] arr, int low, int high, int index, int value){
        if(index < low || index > high || low > high)
            return;
        
        if(low == high)
        {
            arr[index] = value;
            root.data = value;
            return;
        }
        else
        {
            int mid = (low + high)/2;
            if(index <= mid)
            {
                // the update is happening in the left subtree.
                // this means that the right subtree is un-modified.
                root.right = prev.right;
                root.left = new Node(0);
                update(prev.left, root.left,arr, low, mid, index, value);
            }
            else{
                // the update is happening in the right subtree.
                // this means that the left subtree is un-modified.
                root.left = prev.left;
                root.right = new Node(0);
                update(prev.right, root.right, arr, mid+1, high, index, value);
            }
            root.data = root.left.data + root.right.data;
        }
    }
}

public class PersistentSegmentTrees {
    public static void main(String[] args)
    {
        int[] arr = {5,1,8,3,4};
        PersistentSegmentTree pst = new PersistentSegmentTree(10);
        pst.buildTree(pst.versions[0], arr, 0, arr.length-1);
        // pst.printTree(pst.versions[0]);
        
        pst.update(pst.versions[0], pst.versions[1], arr, 0, arr.length-1,1, 7);
        System.out.println("version 1 : ");
        pst.printTree(pst.versions[1]);
        System.out.println("\nversion 0 : ");
        pst.printTree(pst.versions[0]);
        pst.update(pst.versions[0], pst.versions[2], arr, 0, arr.length-1,2, 20);
        System.out.println("version 2 : ");
        pst.printTree(pst.versions[2]);
    }
}
