import java.util.*;

class MinStack {
    
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int minValue = Integer.MAX_VALUE;
    void push(int x)
    {
        st.push(x);
        if(x <= minValue)
        {
            minValue = x;
            minStack.push(x);
        }
    }

    void pop()
    {
        int poppedElement = st.pop();
        if(poppedElement == minStack.peek())
            minStack.pop();
    }

    int peek(){
        return st.peek();
    }

    int getMinimum()
    {
        return minStack.peek();
    }
}

public class MinStackDemo {
    public static void main(String[] args)
    {
        MinStack minStack = new MinStack();// [3,6]
        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
        // minStack.push(7);
        System.out.println(minStack.getMinimum());
        minStack.pop();
        System.out.println(minStack.getMinimum());
    }
}
