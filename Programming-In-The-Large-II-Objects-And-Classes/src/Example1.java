
/**
 * Consider this extremely simplified version of a Student class, which
 * could be used to store information about students taking a course:
 */
public class Example1 {

    public String name;  // Student's name.
    public double test1, test2, test3;  // Grades on three tests.

    public double getAverage() {  // Compute average test grade.

        return ( test1 + test2 + test3 ) / 3;
    }

}  // end of class Student.
