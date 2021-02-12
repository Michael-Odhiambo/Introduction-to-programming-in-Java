
import java.util.Scanner;

public class AdditionQuiz {

    Scanner stdin = new Scanner( System.in );

    // An array to store all the questions.
    AdditionQuestion questions[] = new AdditionQuestion[10];

    // An array to store the user's results.
    double results[] = new double[10];

    public class AdditionQuestion {

        private int a, b;  // The numbers in the problem.

        // Constructor.
        public AdditionQuestion() {
            a = ( int )( Math.random()*50 + 1 );
            b = ( int )( Math.random()*50 + 1 );
        }
        public String getQuestion() {
            return "What is " + a + "+" + b + " ? ";
        }

        public int getCorrectAnswer() {
            return a + b;
        }
    }

    public void createQuiz() {

        // Populate the "questions" array with 10 questions.
        for ( int i = 0; i < questions.length; i++ )
            questions[i] = new AdditionQuestion();

    }

    public void administerQuiz() {

        for ( int i = 0; i < questions.length; i++ ) {
            System.out.print( questions[i].getQuestion() );

            // Get the user's answer.
            double answer = stdin.nextDouble();

            // Add it to the results array.
            results[i] = answer;

        }

    }

    public void gradeQuiz() {

        for ( int i = 0; i < questions.length; i++ ) {
            System.out.print( questions[i].getQuestion() );
            System.out.println( results[i] );

            if ( results[i] != questions[i].getCorrectAnswer() )
                System.out.print( "Correct Answer is: " + questions[i].getCorrectAnswer() );
        }
        System.out.println();
    }

    public static void main( String[] args ) {

        AdditionQuiz myQuiz = new AdditionQuiz();
        myQuiz.createQuiz();
        myQuiz.administerQuiz();
        myQuiz.gradeQuiz();

    }

}
