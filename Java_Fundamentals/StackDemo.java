import java.util.*;

public class StackDemo {
    public static void main(String[] args)
    {
        // // DS<dataType> name = new DS<>();
        // Stack<Integer> st = new Stack<>();
        // System.out.println(st.isEmpty());
        // st.push(5); // adds an element to the top of stack.
        // st.push(7);
        // st.push(8);
        // st.push(9);
        // System.out.println(st.peek()); // returns the top most element from the stack.
        // int poppedElement = st.pop(); // removes the top most element from the stack.
        // System.out.println(poppedElement);
        // System.out.println(st);
        // System.out.println(st.size());

        String input = "(()){})";
        System.out.println(parenthesisMatcher(input));
        System.out.println(minCountToMatch(")))("));
        Stack<Integer> st = new Stack<>();
        System.out.println(st.pop());

    }

    static int minCountToMatch(String input)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<input.length();i++)
        {
            char ch = input.charAt(i);
            if(ch == '(')
                st.push(ch);
            else
            {
                if(!st.isEmpty() && st.peek() == '(')
                {
                    st.pop();
                }
                else
                {
                    st.push(ch);
                }
                 
            }
        }
        return st.size();
    }

    static boolean parenthesisMatcher(String input)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<input.length();i++)
        {
            char ch = input.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else
            {
                if(st.isEmpty())
                    return false;
                char top = st.pop();
                if(ch == ')' && top != '(')
                    return false;
                else if(ch == '}' && top != '{')
                    return false;
                else if(ch == ']' && top != '[')
                    return false;
            }
        }

        return st.size() == 0;
    }
}
