public class StringDiscussion {
    public static void main(String[] args)
    {
        String s = "newton";
        System.out.println(s);

        String reverse = "";
        for(int i=s.length()-1;i>=0;i--)
        {
            reverse = reverse + s.charAt(i);
        }
        System.out.println(reverse);

        // String s2 = new String("school");
        // // System.out.println(s2);

        // // length()
        // // System.out.println(s.length()); // the length of string.

        // // System.out.println(s.charAt(0)); // return the character at zeroth index.

        // // arr[0] = 5;
        
        // String s3 = s.substring(1, 4);
        // System.out.println(s3);
        // System.out.println(s);

        // // concat()
        // String name = "Isaac";
        // String surname = "Newton";

        // System.out.println(name.concat(surname)); // IsaacNewton
        // System.out.println(name);
        // System.out.println(surname);
        // System.out.println(name+surname); // also acts as a concat 

        // System.out.println(s.indexOf('o'));

        // String newString = s.toUpperCase(); // toLowerCase()-> NEWTON -> newton
        // System.out.println(s);
        // System.out.println(newString);


        String s1 = "newton";
        String s2 = "newton";


        String s3 = new String("newton");
        String s4 = new String("newton");

        System.out.println(s3.equals(s4)); // compares the values.
        System.out.println(s1== s3); // compares addresses.



    }
}
