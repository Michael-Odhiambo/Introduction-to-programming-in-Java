

public class Student1 {

    private final String name;  // Student's name.
    public double test1, test2, test3;  // Grades on three tests.

    private int ID;  // Unique ID number for this student.
    private static int nextUniqueID = 0;  // Keep track of the next available unique ID number.

    public Student1( String theName ) {
        // Constructor for Student1 objects;
        // provides a name for the Student.
        // The name can't be null.
        if ( theName == null )
            throw new IllegalArgumentException( "Name can't be null." );
        name = theName;
        nextUniqueID++;
        ID = nextUniqueID;
    }

    public String getName() {
        // Getter method for reading the value of the private instance variable , name.
        return name;
    }

    // Getter method for reading the value of ID.
    public int getID() {
        return ID;
    }

    public double getAverage() {
        // Compute average test grade.
        return ( test1 + test2 + test3 ) / 3;
    }

} // end of Student1 class.
