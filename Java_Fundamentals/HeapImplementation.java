import java.util.Comparator;
import java.util.PriorityQueue;

class Heap{

    int size;
    int capacity;
    int[] heap;

    Heap(int n)
    {
        this.capacity = n;
        this.size = 0;
        heap = new int[this.capacity];
    }

    void swap(int[] heap, int i, int j)
    {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void insert(int data)
    {
        if(this.size >= this.capacity)
            return;
        heap[this.size] = data;
        int index = this.size;
        while(index > 0 && heap[index] > heap[(index-1)/2])
        {
            swap(heap, index, (index-1)/2); // swapping the current node and its parent in case of violation.
            index = (index-1)/2; // recursing up to the parent as the current node till the root node.
        }
        this.size++;
    }


    void heapSort(int size)
    {
        if(size <= 1)
            return;
        swap(heap, 0, size-1); // swapping the root and the last element. This way, the largest element is at the end.
        heapify(0, size-1); // reducing the size of the heap by 1 and calling heapify on root to restructure the heap.
        heapSort(size-1); // recursively calling heap sort on the remaining heap.
    }

    void heapify(int index, int size){
        int parent = index;
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        int minIndex = parent;
        if(left < size && heap[left] > heap[minIndex])
            minIndex = left;
        if(right < size && heap[right] > heap[minIndex])
            minIndex = right;

        if(minIndex != parent)
        {
            swap(heap, parent, minIndex);
            heapify(minIndex, size);
        }
    }

    int remove(){
       if(this.size == 0)
        return -1;
    
        int removedValue = heap[0];
        heap[0] = heap[this.size-1];
        this.size--;
        heapify(0, this.size);
        return removedValue;
    }

    void buildHeap(int[] arr)
    {
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
    }

    void printHeap()
    {
        for(int i=0;i<this.size;i++)
        {
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    int getMinimum()
    {
        return heap[0];
    }
}

class Point{
    int x, y;

    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    int distanceFromOrigin()
    {
        return (int)Math.sqrt((x*x + y*y));
    }
}

class PointComparator implements Comparator<Point>{

    public int compare(Point p1, Point p2)
    {
        return p1.distanceFromOrigin() - p2.distanceFromOrigin();
    }
}


public class HeapImplementation {
    public static void main(String[] args)
    {
        // int[] arr = {5,3,8,2,4,1};
        // Heap hp = new Heap(arr.length);
        // hp.buildHeap(arr);
        // hp.printHeap();
        // hp.heapSort(hp.size);
        // hp.printHeap();
        // System.out.println(hp.remove());
        // hp.printHeap();

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq.add(5);
        // pq.add(1);
        // pq.add(8);
        // pq.add(2);
        // pq.add(7);

        // for(Integer x : pq)
        // {
        //     System.out.print(x+" ");
        // }

        // System.out.println();
        // while(!pq.isEmpty())
        // {
        //     System.out.print(pq.remove()+" ");
        // }
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // {5,3,8,2,4,1}
        // int k = 3;
        // for(int i=0;i<k;i++)
        //     pq.add(arr[i]);
        
        // for(int i=k;i<arr.length;i++)
        // {
        //     if(arr[i] > pq.peek())
        //     {
        //         pq.remove();
        //         pq.add(arr[i]);
        //     }
        // }

        // for(Integer x : pq)
        //     System.out.print(x+" ");
        // System.out.println();

        PriorityQueue<Point> points = new PriorityQueue<Point>(new PointComparator());
        Point p1 = new Point(3,4);
        Point p2 = new Point(3,2);
        Point p3 = new Point(1,7);
        Point p4 = new Point(5,8);
        Point p5 = new Point(9,0);
        Point p6 = new Point(3,0);
        Point[] pArray = {p1,p2,p3,p4,p5,p6};
        int k = 3;
        for(int i=0;i<k;i++)
            points.add(pArray[i]);
        
        for(int i=k;i<pArray.length;i++)
        {
            if(pArray[i].distanceFromOrigin() < points.peek().distanceFromOrigin())
            {
                points.remove();
                points.add(pArray[i]);
            }
        }

        while(!points.isEmpty())
        {
            Point p = points.remove();
            System.out.println(p.x+ " "+p.y+" "+p.distanceFromOrigin());
        }
    }
}
