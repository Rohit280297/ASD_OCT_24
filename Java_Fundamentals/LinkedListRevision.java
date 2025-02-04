import java.util.Comparator;

class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
    }
}

class LinkedList{
    Node head;

    Node addToLast(int data)
    {
        Node newNode = new Node(data);
        if(this.head == null)
            this.head = newNode;
        else
        {
            Node curr = this.head;
            while(curr.next != null)
                curr = curr.next;
            
            curr.next = newNode;
        }

        return head;
    }

    Node addToLast(Node head, Node newNode)
    {
        if(head == null)
            head = newNode;
        else
        {
            Node curr = this.head;
            while(curr.next != null)
                curr = curr.next;
            
            curr.next = newNode;
        }

        return head;
    }

    Node reverse(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node newHead = reverse(head.next);
        this.addToLast(newHead, head);
        return newHead;
    }

    void printList()
    {
        Node curr = this.head;
        while(curr != null)
        {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

}





class NodeComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2){
        if(n1.data > n2.data)
            return 1;

        else if(n1.data < n2.data)
            return -1;
        return 0;
    }
}

public class LinkedListRevision {
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.addToLast(4);
        ll.addToLast(6);
        ll.addToLast( 8);
        ll.printList();
        ll.head = ll.reverse(ll.head);
        
    }
}
