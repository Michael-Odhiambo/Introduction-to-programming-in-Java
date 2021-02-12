

public class FunctionalInterfaces {

    static double sum( FunctionR2R f, int start, int end ) {
        double total = 0;
        for ( int i = start; i <= end; i++ )
            total += f.valueAt( i );

        return total;
    }

    static void doSeveralTimes( Runnable task, int repCount ) {
        for ( int i = 0; i < repCount; i++ )
            task.run();
    }

    public static void main( String[] args ) {
        FunctionR2R sqr = x -> x * x;
        ArrayProcessor concat = ( A, n ) -> { // Parentheses around ( A, n ) are required!
            String str = "";
            for ( int i = 0; i <= n; i++ )
                str += A[i];
            System.out.println( str );

        };  // The semicolon marks the end of the assignment statement.
            // It is not part of the lambda expression.

        String[] nums = new String[4];
        nums[0] = "One";
        nums[1] = "Two";
        nums[2] = "Three";
        nums[3] = "Four";

        for ( int i = 0; i < nums.length; i++ ) {
            concat.process( nums, i );
        }

        System.out.println( sqr.valueAt( 2 ) );
        System.out.printf( "The sum of n squared for n in the range of 1 to 100 is %s\n", sum( x -> x * x, 1, 100 ) );
        System.out.printf("The sum of 2 raised to the power n, for n from 1 to 10 is %s ", sum( x -> Math.pow( 2, x ), 1, 10 ) );
        doSeveralTimes( () -> System.out.println( "Hello World!"), 10 );
    }

}
