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
        while(index > 0 && heap[index] < heap[(index-1)/2])
        {
            swap(heap, index, (index-1)/2); // swapping the current node and its parent in case of violation.
            index = (index-1)/2; // recursing up to the parent as the current node till the root node.
        }
        this.size++;
    }

    void heapify(int index){
        int parent = index;
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        int minIndex = parent;
        if(left < this.size && heap[left] < heap[minIndex])
            minIndex = left;
        if(right < this.size && heap[right] < heap[minIndex])
            minIndex = right;

        if(minIndex != parent)
        {
            swap(heap, parent, minIndex);
            heapify(minIndex);
        }
    }

    int remove(){
       if(this.size == 0)
        return -1;
    
        int removedValue = heap[0];
        heap[0] = heap[this.size-1];
        this.size--;
        heapify(0);
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

public class HeapImplementation {
    public static void main(String[] args)
    {
        int[] arr = {5,3,8,2,4,1};
        Heap hp = new Heap(arr.length);
        hp.buildHeap(arr);
        hp.printHeap();
        System.out.println(hp.remove());
        hp.printHeap();
    }
}
