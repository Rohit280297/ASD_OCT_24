import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}
class Queue{

    int size = 0;
    Node front = null;
    Node rear = null;
    void add(int data) {
        Node newNode = new Node(data);
        if(front == null)
        {
            this.front = newNode;
            this.rear = newNode;
        }
        else
        {
            this.rear.next = newNode;
            this.rear = newNode;
        }
        this.size++;
    }

    int peek() {
        return this.front.data;
    }

    int remove() {

        int poppedData = this.front.data;
        this.front = this.front.next;
        this.size--;
        return poppedData;

    }

    boolean isEmpty() {
        return front == null;
    }

    int size() {
        return this.size;
    }
}

class QueueUsingTwoStacks{

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    void add(int data) // O(n)
    {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }

        st1.push(data);

        while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
    }

    int remove(){ // O(1)
        return st1.pop();
    }

    int peek(){ // O(1)
        return st1.peek();
    }

    int size() { // O(1)
        return st1.size();
    }

    boolean isEmpty(){ // O(1)
        return st1.isEmpty();
    }
}
public class QueueImplementation {
    public static void main(String[] args)
    {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.add(5);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
    }
}
