class Node{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
    }
}
class SegmentTree{
    int[] segmentTree;

    Node[] versions;

    SegmentTree(int n)
    {
        segmentTree = new int[2*n];
    }

    void constructTree(int[] arr,int curr, int low, int high)
    {
        if(low == high)
        {

            segmentTree[curr] = arr[low];
            return;
        }

        int mid = (low + high)/2;
        // constructing left subtree.
        constructTree(arr, 2*curr+1, low, mid);
        // constructing right subtree.
        constructTree(arr, 2*curr+2,mid+1, high);
        segmentTree[curr] = segmentTree[2*curr+1] + segmentTree[2*curr+2];
    }
    
    int getSumInRange(int curr,int low, int high, int l, int r){
        // out of range.
        if(r < low || l > high || r < l)
            return 0;
        
        // entire range.
        if(l <= low && high <= r)
            return segmentTree[curr];

        int mid = low + (high-low)/2;
        return getSumInRange(2*curr+1, low, mid, l, r) // sum in left subtree.
                            +
                            getSumInRange(2*curr+2, mid+1, high, l, r); // sum in right subtree.
            
    }

    void update(int[] arr, int curr, int low, int high, int index, int newVal){
        if(low == high)
        {
            if(low == index)
            {
                arr[index] = newVal;
                segmentTree[curr] = newVal;
                return;
            }
        }

        int mid = low + (high - low)/2;
        if(index <= mid)
            update(arr, 2*curr+1, low,mid, index, newVal); // update in the left subtree.
        else
            update(arr, 2*curr+2, mid+1, high, index, newVal); // update in the right subtree.
        
        segmentTree[curr] = segmentTree[2*curr+1] + segmentTree[2*curr+2];
    }

    void printTree()
    {
        for(int x : segmentTree)
        {
            System.out.print(x+" ");
        }
        System.out.println();
    }
}


public class SegmentTreesImplementation {
    public static void main(String[] args)
    {   
        int[] arr = {5,1,8,3,4};
        int n  = arr.length;
        SegmentTree st = new SegmentTree(n);
        st.constructTree(arr, 0, 0, n-1);
        st.printTree();
        System.out.println(st.getSumInRange(0, 0, n-1, -1, 3));
        st.update(arr, 0, 0, n-1, 1, 7); // arr = {5,7,8,3,4}
        st.printTree();
        System.out.println(st.getSumInRange(0, 0, n-1, 0, 2));
    }
}




