import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    Node insert(Node root, int data)
    {
        if(root == null)
        {
            Node newNode = new Node(data);
            root = newNode;
            return root;
        }

        if(root.data < data){
            root.right = insert(root.right, data);
        }
        else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    void inorder(Node root)
    {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    boolean validateBST(Node root, int min, int max)
    {
        if(root == null)
            return true;
        
        if(root.data < min || root.data > max)
            return false;
        
        return validateBST(root.left, min, root.data - 1) && validateBST(root.right, root.data+1, max);
    }

    int rangeSumBST(Node root, int min, int max)
    {
        if(root == null)
            return 0;
        if(root.data >= min && root.data <= max)
            return root.data + rangeSumBST(root.left, min, max) + rangeSumBST(root.right, min, max);
        if(root.data > max)
            return rangeSumBST(root.left, min, max);
        if(root.data < min)
            return rangeSumBST(root.right, min, max);
        return 0;
    }

    Node deleteFromTree(Node root, int value)
    {
        if(root == null)
            return null;
        
        if(root.data > value)
            return deleteFromTree(root.left, value);
        else if(root.data < value)
            return deleteFromTree(root.right, value);
        else{
            if(root.left == null && root.right == null)
                return null;
            
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;

            // when the root to be deleted has both children.
            Node minRight = minOnRight(root); // maxOnLeft(root);
            root.data = minRight.data;
            root.right = deleteFromTree(root.right, minRight.data); // root.left = deleteFromTree(root.left, maxOnLeft.data);
        }
        return root;
    }

    Node minOnRight(Node root)
    {
        Node curr = root.right;
        while(curr.left != null)
            curr = curr.left;
        return curr; // the minimum on the right subtree of root.
    }

    Node maxOnLeft(Node root)
    {
        Node curr = root.left;
        while(curr.right != null)
            curr = curr.right;
        return curr; // the maximum on the left subtree of root.
    }

    static int count = 0;
    static int ans = -1;
    void kthSmallest(Node root, int k){
        if(root == null)
            return;

        kthSmallest(root.left, k);
        count++;
        if(count == k){
            ans = root.data;
            return;
        }
        kthSmallest(root.right, k);
    }

    int lowestCommonAncestor(Node root, int n1, int n2)
    {
        if(n1 <= root.data && root.data <= n2)
            return root.data;
        if(n2 <= root.data && root.data <= n1)
            return root.data;
        if(n1 < root.data && n2 < root.data)
            return lowestCommonAncestor(root.left, n1, n2);
        if(n1 > root.data && n2 > root.data)
            return lowestCommonAncestor(root.right, n1, n2);
        return 0;
    }
}


class BinaryTree{
    
    Node root;
    ArrayList<Integer> preOrder, inOrder, postOrder;
    Integer currIndex;

    BinaryTree()
    {
        preOrder = new ArrayList<>();
        inOrder = new ArrayList<>();
        postOrder = new ArrayList<>();
    }
    
    void levelOrderTraversal(Node root, int target)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node poppedElement = q.remove();
            System.out.print(poppedElement.data+" ");
            if(poppedElement.left != null)
                q.add(poppedElement.left);
            if(poppedElement.right != null)
                q.add(poppedElement.right);
        }
        System.out.println();
    }

    void depthFirstSearch(Node root)
    {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            Node popped = st.pop();
            System.out.print(popped.data+" ");
            if(popped.right != null)
                st.push(popped.right);
            if(popped.left != null)
                st.push(popped.left);
        }
        System.out.println();
    }

    void depthFirstSearchRec(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        depthFirstSearchRec(root.left);
        depthFirstSearchRec(root.right);
    }

    void preOrderTraversal(Node root)
    {
        if(root == null)
            return;
        preOrder.add(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void inOrderTraversal(Node root)
    {
        if(root == null)
            return;
        inOrderTraversal(root.left);
        inOrder.add(root.data);
        inOrderTraversal(root.right);
    }

    void postOrderTraversal(Node root)
    {
        if(root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        postOrder.add(root.data);
    }

    int sumOfLeafNodes(Node root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.data;
        
        return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
    }

    int height(Node root)
    {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    int maximumInTree(Node root)
    {
        if(root == null)
            return Integer.MIN_VALUE;
        else {
            int leftMax = maximumInTree(root.left); 
            int rightMax = maximumInTree(root.right);
            return Math.max(root.data, Math.max(leftMax, rightMax));
        } 
    }

    void leftView(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node poppedElement = q.remove();
                if(i == 0)
                {
                    System.out.print(poppedElement.data+ " ");
                }
                if(poppedElement.left != null)
                    q.add(poppedElement.left);
                if(poppedElement.right != null)
                    q.add(poppedElement.right);
            }
        }

        System.out.println();
    }

    void rightView(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node poppedElement = q.remove();
                if(i == 0)
                {
                    System.out.print(poppedElement.data+ " ");
                }

                if(poppedElement.right != null)
                    q.add(poppedElement.right);
                if(poppedElement.left != null)
                    q.add(poppedElement.left);
            }
        }
        System.out.println();
    }

    void zigzagTraversal(Node root)
    {
        boolean ltr = false;
        Deque<Node> dq = new LinkedList<Node>();
        dq.add(root);
        while(!dq.isEmpty())
        {
            int size = dq.size();
            for(int i=0;i<size;i++)
            {
                if(ltr){
                    Node poppedElement = dq.removeLast();
                    System.out.print(poppedElement.data+" ");
                    if(poppedElement.left != null)
                        dq.addFirst(poppedElement.left);
                    if(poppedElement.right != null)
                        dq.addFirst(poppedElement.right);
                }else
                {
                    Node poppedElement = dq.removeFirst();
                    System.out.print(poppedElement.data+" ");
                    if(poppedElement.right != null)
                        dq.addLast(poppedElement.right);
                    if(poppedElement.left != null)
                        dq.addLast(poppedElement.left);
                }
            }
            ltr = !ltr;
        }
        System.out.println();
    }

    void constructTreeFromInOrderAndPreOrder()
    {
        this.inOrder.clear();
        this.preOrder.clear();
        this.preOrderTraversal(root);
        this.inOrderTraversal(root);
        int left = 0;
        int n = preOrder.size();
        int right = n-1;
        // this.currIndex = 0;
        int[] currIndex = {0};
        this.root = constructTreeRecursively(preOrder, inOrder, left, right, currIndex);
    }

    int findIndex(ArrayList<Integer> list, int val, int left, int right)
    {
        for(int i=left;i<=right;i++)
        {
            if(list.get(i) == val)
                    return i;
        }
        return -1;
    }

    Node constructTreeRecursively(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int left, int right, int[] currIndex)
    {
        if(left > right || currIndex[0] >= preOrder.size())
            return null;
        
        int rootVal = preOrder.get(currIndex[0]); // identify the value of the root node from the preOrder traversal.
        currIndex[0]++; 
        Node rootNode = new Node(rootVal); // create a root node with the root value.
        int rootIndex = findIndex(inOrder, rootVal, left, right); // find the index of the root value from the inorder traversal.

        // recursively constructing the left and right subtree.
        rootNode.left = constructTreeRecursively(preOrder, inOrder, left, rootIndex-1, currIndex);
        rootNode.right = constructTreeRecursively(preOrder, inOrder, rootIndex+1, right, currIndex);
        return rootNode;
    }

    void flatten(Node root){

        if(root == null)
            return;
        
            flatten(root.left); // recursively flatten the left subtree.
            flatten(root.right); // recursively flatten the right subtree.

            if(root.left != null) // if left subtree is present at root node, we need to move the left subtree to the right.
            {
                Node temp = root.right; // storing reference of the right subtree at root.
                root.right = root.left; // inseting left subtree between the root and the right subtree. 
                root.left = null;

                Node curr = root;
                // starting from root, traversing upto the rightmost node. Once found, we set the right flattened subtree of root as right subtree of the rightmost node.
                while(curr.right != null)
                    curr = curr.right;
                
                curr.right = temp;
            }
    }

    int maxPathSum(Node root, int[] globalMax)
    {
        if(root == null)
            return 0;
        
        //if leftMax or rightMax is negative, we can ignore the left/right sum.
        int leftMax = Math.max(0,maxPathSum(root.left, globalMax));
        int rightMax = Math.max(0,maxPathSum(root.right, globalMax));

        //maximum single path sum i.e either leftsubtree / rightsubstree + root.data
        int singlePathSum = Math.max(leftMax, rightMax) + root.data;
        int currMaxSum = leftMax + root.data + rightMax;

        int maxPathSumValue = Math.max(singlePathSum, currMaxSum);
        
        // COnsidering the maximum of root.data and the maxPathSum.
        int max = Math.max(maxPathSumValue, root.data); 

        globalMax[0] = Math.max(globalMax[0], max);

        return root.data + Math.max(leftMax, rightMax);
    }

    int sumOfAllNumbers(Node root, int sum)
    {
        if(root == null)
            return 0;
        
        sum = sum * 10 + root.data;
        if(root.left == null && root.right == null)
            return sum;
        
        return sumOfAllNumbers(root.left, sum) + sumOfAllNumbers(root.right, sum);
    }

    boolean isMirrorTree(Node left, Node right){

        if(left == null && right == null)
            return true;
        if((left != null && right == null) ||(left == null && right != null))
            return false;
        if(left.data != right.data)
            return false;
        return isMirrorTree(left.left, right.right) && isMirrorTree(left.right, right.left);
    }

    boolean isMirrorTreeIterative(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty())
        {
            Node n1 = q.remove();
            Node n2 = q.remove();

            if(n1 == null && n2 == null)
                continue;
            if((n1 == null && n2 != null) || (n1 != null && n2 == null))
                return false;
            if(n1.data != n2.data)
                return false;

            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }
}

public class BinaryTreeImplementation {
    public static void main(String[] args)
    {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(4);
        bt.root.left = new Node(3);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(0);
        bt.root.left.right = new Node(18);
        bt.root.right.left = new Node(18);
        bt.root.right.right = new Node(0);
        // bt.levelOrderTraversal(bt.root);
        // System.out.println();
        // bt.depthFirstSearchRec(bt.root);
        // System.out.println();
        // bt.preOrderTraversal(bt.root);
        // System.out.println();
        // bt.inOrderTraversal(bt.root);
        // System.out.println();
        // bt.postOrderTraversal(bt.root);
        // System.out.println();
        // System.out.println(bt.sumOfLeafNodes(bt.root));
        // System.out.println(bt.height(bt.root));
        // System.out.println(bt.maximumInTree(bt.root));
        // bt.leftView(bt.root);
        // bt.rightView(bt.root);
        // bt.zigzagTraversal(bt.root);
        // bt.inOrder.clear();
        // System.out.println("Before");
        // bt.inOrderTraversal(bt.root);
        // for(int x : bt.inOrder)
        //     System.out.print(x+" ");
        // System.out.println();
        // bt.inOrder.clear();
        // bt.constructTreeFromInOrderAndPreOrder();
        // bt.inOrder.clear();
        // bt.inOrderTraversal(bt.root);
        // System.out.println("After");
        // for(int x : bt.inOrder)
        //     System.out.print(x+" ");
        // System.out.println();
        // bt.preOrderTraversal(bt.root);
        // for(int x : bt.preOrder)
        //     System.out.print(x+" ");
        // System.out.println();
        // bt.flatten(bt.root);
        // bt.inOrderTraversal(bt.root);
        // for(int x : bt.inOrder)
        //     System.out.print(x+" ");

        // int[] globalMax = {Integer.MIN_VALUE};
        // bt.maxPathSum(bt.root, globalMax);
        // System.out.println(globalMax[0]);
        // System.out.println(bt.sumOfAllNumbers(bt.root, 0));

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(bst.root, 5);
        bst.insert(bst.root,8);
        bst.insert(bst.root,1);
        bst.insert(bst.root,6);
        bst.insert(bst.root,9);
        // // bst.inorder(bst.root);
        // // System.out.println(bst.validateBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // // System.out.println(bst.rangeSumBST(bst.root, 2, 7));
        // bst.kthSmallest(bst.root, 3);
        // System.out.println(BinarySearchTree.ans);
        // System.out.println(bt.isMirrorTreeIterative(bt.root));
        System.out.println(bst.lowestCommonAncestor(bst.root, 6,9));

    }
}
