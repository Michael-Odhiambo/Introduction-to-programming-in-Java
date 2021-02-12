
/*

Suppose there are N people in a room. What's the chance that there are two people in the room
who have the same birthday? ( That is, they were born on the same day in the same month, but not
necessarily in the same year. ) Most people severely underestimate the probability. We
will actually look at a different version of the question: Suppose you choose pople at random
and check their birthdays. How many people will you check before you find one who has the same
birthday as someone you've already checked? Of course, the answer in a particular case
depends on random factors, but we can simulate the experiment with a computer program and
run the program several times to get an idea of how many people need to be checked on average.

To simulate the experiment, we need to keep track of each birthday we find. There are
365 different possible birthdays. ( We'll ignore leap years. )
For each possible birthday, we need to keep track of whether or not we have already found a person
who has that birthday. The answer to this question is a boolean value, true or false. To hold the data
for all 365 possible birthdays, we use an array of 365 boolean values.
 */
public class BirthdayProblem {

    public static void main( String[] args ) {
        // For recording the possible birthdays that have been seen so far. A value
        // of true in used[i] means that a person whose birthday is the i-th day of the
        // year has been found.
        boolean[] used;
        // The number of people who have been checked.
        int count;
        // Initially, all entries are false.
        used = new boolean[ 365 ];
        count = 0;

        while ( true ) {
            // Select a birthday at random, from 0 to 364. If the birthday has already
            // been used, quit. Otherwise, record the birthday as used.

            int birthday;  // The selected birthday.
            birthday = ( int )( Math.random() * 365 );
            count++;

            System.out.printf( "Person %d has birthday number %d\n", count, birthday );

            if ( used[ birthday ] ) {
                // This birthday was found before; it's a duplicate. We are done.
                break;
            }

            used[ birthday ] = true;

        }  // end while.

        System.out.println();
        System.out.printf( "A duplicate birthday was found after %d tries.\n", count );

    }  // end of main().

}  // end of class BirthdayProblem.
