public class Operators {
    public static void main(String[] args){
        // Operators.
        // Assignment operators :
        // int a = 5;
        // a += 5; // add 5 to a, assign the new value to a.
        // System.out.println(a);

        // a-= 4;
        // System.out.println(a);

        // a*=5;
        // a/=5;
        // a%=5;

        // Arithmetic operators.
        // int x = 4;
        // int y =3 ;
        // System.out.println(x+y); // addition.
        // System.err.println(x-y); // subtraction.
        // System.err.println(x*y); // product.
        // System.err.println(x/y); // division (/) -> quotient.

        // Increment and Decrement operators.
        // int x = 4;
        // System.out.println(x);
        // int a = ++x;
        // System.out.println(a+" "+x);

        // Relational operators :
        // >= , <= , < , >
        // int x = 5;
        // // (x >= 4)  -> returns a boolean value. 
        // System.out.println(x >= 4);
        // // ==  -> equality operator.
        // // != -> non equality operator.
        // System.out.println(x == 5);
        // System.err.println(x != 5);

        // Logical operators.
        // boolean x = true;
        // boolean y = false;
        // System.err.println(x && y); // logical AND.
        // System.err.println(x || y); // logical OR.
        // System.out.println(!x);

        // Left shift operator.
        // int x = 5;
        // System.out.println((x >> 1));
        // System.out.println((x << 1));

        // Conditionals.
        int x = 4;
        if(x%2 == 0)
        {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
