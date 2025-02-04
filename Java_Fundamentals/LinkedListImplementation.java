import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoubleLinkedList{

    Node head;
    Node tail;
    int size;

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

    void addToLast(int data)
    {
        Node newNode = new Node(data);

        if(this.head == null)
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            Node curr = this.head;
            while(curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
            this.tail = newNode;
        }

        this.size++;
    }

    void addToFront(int data)
    {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
        this.size++;
    }

    void removeLast(){
        Node curr = this.head;

        if(this.head.next == null)
        {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        while(curr.next.next != null)
        {
            curr = curr.next;
        }
        curr.next = null;
        this.tail.prev = null;
        this.tail = curr;
        this.size--;
    }

    void addAtPosition(int pos, int data)
    {
        Node newNode = new Node(data);
        if(pos == 1){
            addToFront(data);
            return;
        }
        Node curr = this.head;
        int currPos = 1;
        while(currPos < pos-1)
        {
            curr = curr.next;
            currPos++;
        }

        Node temp = curr.next;
        curr.next = newNode;
        if(temp != null)
        {
            temp.prev = newNode;
        }
        newNode.next = temp;
        newNode.prev = curr;
        this.size++;
    }

    void reverseList(){

        Node curr = head;
        Node prev = null;
        while(curr != null)
        {
            Node temp = curr.next;
            curr.next = prev;
            if(prev != null)
                prev.prev = curr;
            prev = curr;
            if(temp != null)
                temp.prev = curr;
            curr = temp;
        }

        this.tail = head;
        this.head = prev;
    }
}

class SingleLinkedList{
    Node head;
    int size = 0;

    void printList()
    {
        Node curr = this.head;
        while(curr != null)
        {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    void addToLast(int data)
    {
        Node newNode = new Node(data);

        if(this.head == null)
        {
            this.head = newNode;
        }
        else{
            Node curr = this.head;
            while(curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = newNode;
        }

        this.size++;
    }

    void addToFront(int data)
    {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    void removeLast(){
        Node curr = this.head;

        if(this.head.next == null)
        {
            this.head = null;
            this.size--;
            return;
        }

        while(curr.next.next != null)
        {
            curr = curr.next;
        }
        curr.next = null;
        this.size--;
    }

    void removeFirst()
    {
        if(this.head == null)
            return;
        this.head = this.head.next;
        this.size--;
    }

    void addAtPosition(int pos, int data)
    {
        Node newNode = new Node(data);
        if(pos == 1){
            addToFront(data);
            return;
        }
        Node curr = this.head;
        int currPos = 1;
        while(currPos < pos-1)
        {
            curr = curr.next;
            currPos++;
        }

        Node temp = curr.next;
        curr.next = newNode;
        newNode.next = temp;
        this.size++;
    }

    void removeAtPos(int pos)
    {

    }

    int kthNodeFromEnd(int pos)
    {
        Node fptr = this.head;
        Node sptr = this.head;

        int currPos = 1;
        while(currPos++ < pos)
        {
            fptr = fptr.next;
        }

        while(fptr.next != null)
        {
            fptr = fptr.next;
            sptr = sptr.next;
        }
        return sptr.data;
    }

    void reverseList(){

        Node curr = head;
        Node prev = null;
        while(curr != null)
        {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        this.head = prev;
    }

    int getIndex(int data)
    {
        // 3 5 4 7
        int res = -1;
        Node curr = this.head;
        while(curr != null)
        {
            if(curr.data == data)
                return ++res;
            curr = curr.next;
            ++res;
        }

        return -1;
    }

    int size()
    {
        return this.size;
    }

    boolean isEmpty()
    {
        return this.head == null;
    }

}

class NodeComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2){
        if(n1.data >= n2.data)
            return -1;

        else
            return 1;
        
        
    }
}

public class LinkedListImplementation {
    public static void main(String[] args)
    {
        // SingleLinkedList ll = new SingleLinkedList();
        // ll.addToLast(2);
        // ll.addToLast(4);
        // ll.addToLast(7);
        // ll.addToFront(9); // 9 6 2 4 7
        // ll.addAtPosition(2, 6);
        // ll.printList();
        // System.out.println();
        // // System.out.println(ll.getIndex(7));
        // // System.out.println(ll.kthNodeFromEnd(1));
        // ll.reverseList();
        // ll.printList();

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        Node n1 = new Node(4);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(9);
        pq.add(n1);
        pq.add(n2);
        pq.add(n3);
        pq.add(n4);

        while(!pq.isEmpty())
        {
            System.out.print(pq.peek().data+" ");
            pq.remove();
        }
        System.out.println();
        // DoubleLinkedList dll = new DoubleLinkedList();
        // dll.addToLast(5);
        // dll.addToLast(7);
        // dll.addToFront(6);
        // dll.printList();
        // dll.removeLast();
        // dll.printList();
        // dll.addAtPosition(3, 9);
        // dll.printList();
        // dll.addAtPosition(2, 12);
        // dll.printList();
        // dll.reverseList();
        // dll.printList();
    }
}
