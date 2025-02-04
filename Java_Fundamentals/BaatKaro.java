public class BaatKaro {
    public static void main(String[] args) {
        Student s1 = new Student("Rajesh", 97);
        System.out.println(s1.getTotalMarks());
        s1.setTotalMarks(27);
        System.out.println(s1.getTotalMarks());
    } 
}

class Student
{
    int roll;
    String name;
    private int totalMarks;

    // getters and setters.
    int getTotalMarks(){
        return this.totalMarks;
    }

    void setTotalMarks(int marks){
        this.totalMarks = marks;
    }
    
    Student(String name, int totalMarks)
    {
        this.name = name;
        this.totalMarks = totalMarks;
    }
}


