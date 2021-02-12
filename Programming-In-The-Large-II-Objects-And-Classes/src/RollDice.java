

public class RollDice {

    public static void main( String[] args ) {

        ModifiedPairOfDice theDice = new ModifiedPairOfDice();  // The Dice being rolled.
        StatCalc calculator = new StatCalc();  // Calculator object for calculating the statistics.

        /**
         * There are 11 possible totals for the dice. We need to calculate the average number
         * of rolls it takes to get each of the possible total.
         */
        for ( int i = 2; i <= 12; i++ ) {
            for ( int j = 1; j <= 10000; j++ ) {

                int numberOfRolls = 0;  // keep track of the number of rolls it will take to get a total
                                        // of i.
                do {
                    theDice.roll();
                    numberOfRolls++;  // Count this roll.

                } while ( theDice.getDie1() + theDice.getDie2() != i );
                calculator.enter( numberOfRolls );

            }
            System.out.println( i );
            System.out.printf( "Average number of rolls: %s \n", calculator.getMean() );
            System.out.printf( "The standard deviation: %s \n", calculator.getStandardDeviation() );
            System.out.printf( "Maximum number of rolls: %s \n", calculator.getMax() );

        }

    }
}
