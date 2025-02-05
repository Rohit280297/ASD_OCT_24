
class FenwickTree{

    int[] tree;
    int n;
    FenwickTree(int n)
    {
        this.n = n;
        tree = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            tree[i] = 0;
        }
    }

    void insert(int index, int value)
    {
        index++;

        while(index <= n){

            tree[index] += value;
            // going from parent to child.
            index += (index & (-index));
        }
    }

    int getPrefixSum(int index)
    {
        int sum = 0;
        index++;

        while(index > 0)
        {
            sum += tree[index];
            // going from child to its parent.
            index -= (index & (-index));
        }

        return sum;
    }

    void buildTree(int[] arr)
    {
        for(int i=0;i<this.n;i++)
        {
            insert(i, arr[i]);
        }
    }

    void printTree()
    {
        for(Integer x : this.tree){
            System.out.print(x+" ");
        }

        System.out.println();
    }


    int getSumInRange(int low, int high)
    {   
        return getPrefixSum(high) - getPrefixSum(low-1);
    }
}

public class FenwickTreeImplementation {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8};
        FenwickTree ft = new FenwickTree(arr.length);
        ft.buildTree(arr);
        ft.printTree();
        System.out.println(ft.getPrefixSum(4));
        System.out.println(ft.getSumInRange(4, 7));
    }
}
