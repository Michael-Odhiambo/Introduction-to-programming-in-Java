
import java.util.Scanner;

/**
 * Write a program that administers a basic addition quiz to the user. There should be
 * ten questions. Each question is a simple addition problem such as 17 + 42, where the
 * numbers in the problem are chosen at random ( and are not too big ). The program should
 * ask the user all ten questions and get the user's answers. After asking all the questions,
 * they should be printed out again with the user's answer. If the user got the answer right,
 * the program should say so; if not, the program should give the correct answer. At
 * the end, tell the user their score on the quiz, where each correct answer count for ten
 * points.
 * The program should use three subroutines, one to create the quiz, one to administer the quiz,
 * and one to grade the quiz. It can use three arrays, with three global variables of type
 * int[], to refer to the arrays. The first array holds the first number from every question,
 * the second holds the second number from every question, and the third holds the user's answers.
 */
public class AdditionQuiz {

    /**
     * Member variables representing three arrays used to store the first number of every question,
     * the second number of every question and the user's answers.
     */
    static final int[] firstNumber = new int[10];
    static final int[] secondNumber = new int[10];
    static final int[] userAnswers = new int[10];

    /**
     * This subroutine generates a pair of random numbers each of which will be used as a question
     * that will be administered to the user. The range is between 1 and 25. The numbers that are
     * generated are inserted into the firstNumber array and secondNumber array respectively.
     */
    static void createQuiz() {

        int count = 0;

        // Populate the arrays.
        do {
            int num1 = ( int )( Math.random() * 25 ) + 1;
            firstNumber[ count ] = num1;
            int num2 = ( int )( Math.random() * 25 ) + 1;
            secondNumber[ count ] = num2;

            count++;

        } while ( count < 10 );

    }  // end of createQuiz()

    /**
     * This subroutine administers the quiz.
     */
    static void administerQuiz() {

        Scanner stdin = new Scanner( System.in );   // Create a scanner object to be used for getting the users responses.

        for ( int i = 0; i < firstNumber.length; i ++ ) {
            System.out.printf( "%d + %d = ", firstNumber[i], secondNumber[i] );
            int usersAnswer = stdin.nextInt();
            userAnswers[ i ] = usersAnswer;
        }
    }

    /**
     * This subroutine grades the results.
     */
    static void grade() {
        // Count the number of correct answers.
        int correctAnswers = 0;

        for ( int i = 0; i < userAnswers.length; i++ ) {
            if ( firstNumber[i] + secondNumber[i] == userAnswers[i] ) {
                System.out.printf( "%d + %d = %d\n", firstNumber[i], secondNumber[i], firstNumber[i] + secondNumber[i] );
                correctAnswers++;
            }
            else {
                System.out.print( "Wrong " );
                System.out.printf( "%d + %d != %d\n", firstNumber[i], secondNumber[i], userAnswers[i] );
                System.out.printf( "Answer: %d\n", firstNumber[i] + secondNumber[i] );
            }

        }
        System.out.printf( "You got %d questions right.\n", correctAnswers );
        System.out.printf( "Your score is %d%%", correctAnswers * 10 );
    }

    public static void main( String[] args ) {
        createQuiz();
        administerQuiz();
        grade();
    }
}
