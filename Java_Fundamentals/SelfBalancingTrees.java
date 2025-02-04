
class Node{
    int data;
    Node left;
    Node right;
    Node parent;
    int height;
    char color;

    Node(int data)
    {
        this.data = data;
        this.height = 1;
        this.color = 'R';
    }
}


class AVLTree{
    Node root;

    Node rotateLeft(Node root)
    {
        Node right = root.right;
        Node rLeft = right.left;

        right.left = root;
        root.right = rLeft;

        updateHeight(root);
        updateHeight(right);

        return right;
    }

    Node rotateRight(Node root)
    {
        Node left = root.left;
        Node lRight = left.right;
        left.right = root;
        root.left = lRight;

        updateHeight(root);
        updateHeight(left);

        return left;
    }

    int height(Node curr)
    {
        if(curr == null)
            return 0;
        return curr.height;
    }

    void updateHeight(Node root)
    {
        if(root == null)
            return;
        
            root.height = 1 + Math.max(height(root.left), height(root.right));
    }

    Node deleteNode(Node root, int data){
        if(root == null)
            return null;
        if(root.data > data)
            root.left =  deleteNode(root.left, data);
        else if(root.data < data)
            root.right =  deleteNode(root.right, data);
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
            root.right = deleteNode(root.right, minRight.data); // root.left = deleteFromTree(root.left, maxOnLeft.data);
        }

        // balancing the tree code goes here.

        // update the height of the root.
        updateHeight(root);

        // check the balance factor.
        int balanceFactor = getBalanceFactor(root);

        // check for type of rotation.
        // left left rotation
        if(balanceFactor < -1 && getBalanceFactor(root.right) < -1)
            return rotateLeft(root);
        // right right rotation
        if(balanceFactor > 1 && getBalanceFactor(root.left) > 1)
            return rotateRight(root);
        // left right rotation
        if(balanceFactor > 1 && getBalanceFactor(root.left) < -1)
        {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        // right left rotation.
        if(balanceFactor < -1 && getBalanceFactor(root.right) > 1) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }

    Node insert(Node root, int data)
    {
        if(root == null)
            return new Node(data);
        if(data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        
        // update the height of the root node.
        updateHeight(root);

        // check the balance factor for root.
        int balanceFactor = getBalanceFactor(root);

        // balancing the tree.
        // left left rotation.
        if(balanceFactor < -1 && data > root.right.data)
            return rotateLeft(root);
        // right right rotation.
        if(balanceFactor > 1 && data < root.left.data)
            return rotateRight(root);
        // left right rotation.
        if(balanceFactor > 1 && data > root.left.data)
        {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        // right left rotation.
        if(balanceFactor < -1 && data < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
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

    int getBalanceFactor(Node curr)
    {
        return height(root.left) - height(root.right);
    }

    void preOrder(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

// class RBNode extends Node {
//     char color;
//     Node parent;

//     RBNode(int data){
//         super(data);
//         this.color = 'R';
//     }
// }

class RedBlackTree{

    Node root;
    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;

    void preOrder(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    Node rotateLeft(Node root)
    {
        Node right = root.right;
        Node rLeft = right.left;
        right.left = root;
        root.parent = right;
        root.right = rLeft;
        // update the parent of the rotated nodes.
        if(rLeft != null)
            rLeft.parent= root;
        return right;
    }

    Node rotateRight(Node root)
    {
        Node left = root.left;
        Node lRight = left.right;
        left.right = root;
        root.parent = left;
        root.left = lRight;
        // update the parent of the rotated nodes.
        if(lRight != null)
            lRight.parent = root;
        return left;
    }

    Node insert(Node root, int data)
    {
        boolean rrConflict = false;
        if(root == null){
            Node newNode = new Node(data);
            if(this.root == null){
                this.root = newNode;
                this.root.parent = null;
                this.root.color = 'B';
            }
            return newNode;
        }
        else if(data < root.data)
        {
            root.left = insert(root.left, data);
            root.left.parent = root; // update the parent of the left child.
            if(root != this.root) {
                if(root.color == 'R' && root.left.color == 'R')
                    rrConflict = true;
            }
        }
        else if(root.data < data)
        {
            root.right = insert(root.right, data);
            root.right.parent = root; // update the parent of the right child.
            if(root != this.root) {
                if(root.color == 'R' && root.right.color == 'R')
                rrConflict = true;
            }
        }

        // rotations.
        // 1. LL Rotation
        if(this.ll)
        {
            // left left rotation.
            root = this.rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.ll = false;
        }
        // 2. RR Rotation.
        if(this.rr)
        {
            // right right rotation.
            root = this.rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.rr = false;
        }
        // 3. LR Rotation.
        if(this.lr){
            // lr rotation
            root.left = this.rotateLeft(root.left);
            root = this.rotateRight(root);
            root.color = 'B';
            root.left.color = 'R';
            this.lr = false;
        }
        // 4. Rl Rotation.
        if(this.rl){
            // rl rotation.
            root.right = this.rotateRight(root.right);
            root = this.rotateLeft(root);
            root.color = 'B';
            root.right.color = 'R';
            this.rl = false;
        }

        // resolving the RR conflict.
        if(rrConflict)
        {
            // check the uncle node.
            if(root.parent.left == root) // root is the left child.
            {
                Node uncle = root.parent.right;
                if(uncle == null || uncle.color == 'B')
                {
                    if(root.left != null)
                        this.rr = true;
                    else
                        this.lr = true;
                }
                else{ // uncle is red.
                    root.color = 'B';
                    uncle.color = 'B';
                    // change the color of grandparent(if not root) to red 
                    if(root.parent != this.root)
                        root.parent.color = 'R';
                }
            }
            else { // root is the right child of its parent.
                Node uncle = root.parent.left;
                if(uncle == null || uncle.color == 'B')
                {
                    if(root.right != null)
                        this.ll = true;
                    else
                        this.rl = true;
                }
                else // uncle is red.
                {
                    root.color = 'B';
                    uncle.color = 'B';
                    if(root.parent != this.root)
                        root.parent.color = 'R';
                }
            }

            rrConflict = false;
        }

        return root;
    }
}

public class SelfBalancingTrees {
    public static void main(String[] args)
    {
        // AVLTree t = new AVLTree();
        // t.root = t.insert(t.root, 1);
        // t.root = t.insert(t.root, 2);
        // t.root = t.insert(t.root, 3);
        // t.root = t.insert(t.root, 4);
        // t.root = t.insert(t.root, 5);
        // t.root = t.insert(t.root, 0);
        // t.preOrder(t.root);
        // System.out.println();
        // t.root = t.deleteNode(t.root, 2);
        // t.preOrder(t.root);

        RedBlackTree rbTree = new RedBlackTree();
        rbTree.root = rbTree.insert(rbTree.root, 4);
        rbTree.root = rbTree.insert(rbTree.root, 5);
        rbTree.root = rbTree.insert(rbTree.root, 6);
        rbTree.root = rbTree.insert(rbTree.root, 7);
        rbTree.root = rbTree.insert(rbTree.root, 8);
        rbTree.root = rbTree.insert(rbTree.root, 12);
        rbTree.root = rbTree.insert(rbTree.root, 2);
        rbTree.root = rbTree.insert(rbTree.root, 1);
        rbTree.preOrder(rbTree.root);
    }
}
