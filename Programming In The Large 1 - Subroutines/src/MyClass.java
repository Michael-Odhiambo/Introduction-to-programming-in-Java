/**
 * This exercise asks you to write a few lambda expressions and a function that returns a
 * lambda expression as its value. Suppose that a function interface ArrayProcessor is defined
 * as :
 *
 *                public interface ArrayProcessor {
 *                    double apply( double[] array );
 *                }
 *
 * Write a class that defines four public static final variables of type ArrayProcessor
 * that processes an array in the following ways: finds the maximum value in the array, find the
 * minimum value in an array, find the sum of the values in the array, and find the average
 * of the values in the array. In each case, the value of the variable should be given by a
 * lambda expression. The class should also define a function
 *
 *                public static ArrayProcessor counter( double value ) {...}
 *
 * This function should return an ArrayProcessor that counts the number of times value occurs
 * in an array. The return value should be given as a lambda expression. The class should have a main()
 * routine that tests your work.
 *
 */
public class MyClass {

    /**
     * Finds the maximum value in the array.
     */
    public static final ArrayProcessor1 max = nums -> {

        double maxValue = nums[0];  // Set the maximum value to be largest number we've seen so far.

        for ( int i = 1; i < nums.length; i++ ) {
            if ( nums[i] > maxValue )
                maxValue = nums[i];
        }
        return maxValue;

    };  // End of the lambda statement.

    /**
     * Finds the minimum value in the array.
     */
    public static final ArrayProcessor1 min = nums -> {

        double minValue = nums[0];  // Set the minimum value to the smallest value we've seen so far.

        for ( int i = 1; i < nums.length; i++ ) {
            if ( nums[i] < minValue )
                minValue = nums[i];
        }
        return minValue;

    };  // End of the lambda statement.


    /**
     * Finds the sum of the values in the array.
     */
    public static final ArrayProcessor1 sum = nums -> {

        double theSum = 0;  // Initial sum is zero.

        for ( int i = 0; i < nums.length; i++ ) {
            theSum += nums[i];
        }
        return theSum;
    };  // End of the lambda statement.

    /**
     * Finds the average of the values in the array.
     */
    public static final ArrayProcessor1 average = nums -> {
        return sum.apply( nums ) / nums.length;

    };  // End of the lambda statement.

    /**
     * This function should return an ArrayProcessor that counts the number of times value occurs
     * in an array. The return value should be given as a lambda expression. The class should have a main()
     * routine that tests your work.
     * @param value the value being counted.
     */
    public static ArrayProcessor1 counter( double value ) {
        return nums -> {
            int count = 0;  // Initialize count to zero.

            for ( int i = 0; i < nums.length; i++ ) {
                if ( nums[i] == value )
                    count++;
            }
            return count;
        };
    }

    public static void main( String[] args ) {

        double[] firstList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] secondList = { 17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14 };
        double[] myArray = new double[ 10 ];

        for ( int i = 0; i < myArray.length; i++ )
            myArray[i] = i;

        System.out.printf( "The minimum value in my array is %s \n", min.apply( myArray ) );
        System.out.printf( "The maximum value in my array is %s \n", max.apply( myArray ) );
        System.out.printf( "The average of the values in my array is %s \n", average.apply( myArray ) );
        System.out.printf( "%s appears %s times in the array.\n", 17, counter( 17 ).apply( secondList ) );
    }

}
