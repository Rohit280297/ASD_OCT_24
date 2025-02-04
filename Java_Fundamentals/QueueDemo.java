import java.util.*;

public class QueueDemo {
    public static void main(String[] args)
    {
        //DataStructure<DataType> name = new DataStructure<>();
        Queue<Integer> q = new LinkedList<>();
        // System.out.println(q.isEmpty());
        q.add(7); // enqueue() : adds an element to the end of the queue.
        q.add(8);
        q.add(6);
        q.add(4);
        System.out.println(q);

        // PriorityQueue;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(7); // enqueue() : adds an element to the end of the queue.
        pq.add(8);
        pq.add(6);
        pq.add(4);
        System.out.println(pq);

        // Deque
        Deque<Integer> dq = new LinkedList<>();
        
    }
}
