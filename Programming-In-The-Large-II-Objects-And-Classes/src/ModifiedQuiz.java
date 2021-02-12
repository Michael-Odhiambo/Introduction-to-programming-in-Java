

public class ModifiedQuiz extends AdditionQuiz {

    // An array to hold the questions.
    private IntQuestion[] questions = new IntQuestion[11];

    // An array to store the user's results.
    double results[] = new double[11];

    // This class represents addition questions.
    public class AdditionQuestion implements IntQuestion {

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

    // This class represents subtraction questions.
    public class SubtractionQuestion implements IntQuestion {

        private int a, b;  // The numbers in the problem.

        // Constructor.
        public SubtractionQuestion() {
            a = ( int )( Math.random()*50 + 1 );
            b = ( int )( Math.random()*50 + 1 );

            // Make sure a is greater than or equal to b for the result to be non-negative.
            while ( a < b ) {
                a = ( int )( Math.random()*50 + 1 );
            }
        }

        public String getQuestion(){ return "What is " + a + "-" + b + " ? "; }

        public int getCorrectAnswer() { return a - b; }
    }

    // An additional non-math question implemented using an anonymous class.
    IntQuestion bigQuestion = new IntQuestion() {
        public String getQuestion() {
            return "What is the answer to the ultimate question of life, the universe, and everything? ";
        }

        public int getCorrectAnswer() {
            return 42;
        }
    };

    // Constructor.
    public ModifiedQuiz() {

        // Add the questions to into the array.
        String currentQuestion = "+";
        int position = 0;  // current position in the array.
        for ( int i = 0; i <= 1; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                if ( currentQuestion.equals("+") )
                    questions[ position ] = new AdditionQuestion();
                else
                    questions[ position ] = new SubtractionQuestion();
                position++;
            }
            currentQuestion = "-";
        }
        questions[ position ] = bigQuestion;


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
            System.out.print( results[i] );

            if ( results[i] != questions[i].getCorrectAnswer() )
                System.out.println( " Correct Answer is: " + questions[i].getCorrectAnswer() );
        }

    }


    public static void main( String[] args ) {

        ModifiedQuiz myQuiz = new ModifiedQuiz();
        myQuiz.administerQuiz();
        myQuiz.gradeQuiz();

    }

}
