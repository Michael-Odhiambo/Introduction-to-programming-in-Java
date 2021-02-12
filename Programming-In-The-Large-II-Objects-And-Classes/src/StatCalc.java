/**
 * A common programming task is computing statistics of a set of numbers. ( A statistic is
 * a number that summarizes some property of a set of data. ) Common statistics include
 * the mean ( also known as the average ) and the standard deviation ( which tells how spread
 * out the data are from the mean. ) If calc is a variable of type StatCalc, then the following
 * instance methods are available:
 *
 * - calc.enter( item ) where item is a number, adds the item to the dataset.
 * - calc.getCount() is a function that returns the number of items that have been
 *               added to the dataset.
 * - calc.getSum() is a function that returns the sum of all the items that have been
 *               added to the dataset.
 * - calc.getMean() is a function that returns the average of all the items.
 * - calc.getStandardDeviation() is a function that returns the standard deviation
 *                of the items.
 *
 * Typically, all the data are added one after the other by calling the enter() method
 * over and over, as the data become available. After all the data have been entered, any
 * of the other methods can be called to get statistical information about the data. The
 * methods getMean() and getStandardDeviation() should only be called if the number
 * of items is greater than zero.
 *
 * Add instance methods getMax() and getMin(). The getMax() method should return the largest of all
 * the items that have been added to the dataset, and getMin() should return the smallest. You will
 * need to add two new instance variables to keep track of the largest and smallest items that
 * have been seen so far.
 *
 * Test your new class by using it in a program to compute statistics for a set of non-zero numbers
 * entered by the user. Start by creating an object of type StatCalc.
 *
 * Read numbers from the user and add them to the dataset. Use 0 as a sentinel value ( that is
 * stop reading numbers when the user enters 0 ). After all the user's non-zero numbers have been
 * entered, print out each of the six statistics that are available from calc.
 */

import java.util.Scanner;

public class StatCalc {

    // The sum of the values.
    private double sum;
    // The square sum of all the values.
    private double squareSum;
    // The number of values.
    private int n;

    // Keep track of the minimum and maximum values.
    private double min;
    private double max;

    // Add a number to the dataset.
    public void enter( double num ) {

        // Check if this number is the minimum or maximum.
        if ( this.n > 0 ) {
            if ( num > this.max )
                this.max = num;
            else if ( num < min )
                    this.min = num;
        } else {
            this.min = num;
            this.max = num;
        }

        // Count this number.
        this.n++;
        // Add this number to sum.
        this.sum += num;

        // Add the square of this number to squareSum.
        this.squareSum += num*num;

    }

    // Get the number of items in the dataset.
    public int getCount() {
        return this.n;
    }

    // Get the sum of the values in the dataset.
    public double getSum() {
        return this.sum;
    }

    // Get the minimum and maximum values.
    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    // Get the mean.
    public double getMean() {
        if ( this.n < 1 )
            throw new IllegalArgumentException( "There should be at-least one number." );

        return this.getSum() / this.getCount();
    }

    // Get the standard deviation.
    public double getStandardDeviation() {
        if ( this.n < 1 )
            throw new IllegalArgumentException( "There should be at-least one number." );

        double theMean = this.getMean();
        return Math.sqrt( this.squareSum / this.n - theMean * theMean );
    }

    public static void main( String[] args ) {

        Scanner stdin = new Scanner( System.in );

        // Create a StatCalc object.
        StatCalc Calculator = new StatCalc();
        double value;

        // Read input from the user.
        System.out.println( "Enter your values. Enter 0 to end." );

        do {

            System.out.print( "-> " );

            value = stdin.nextDouble();
            if ( value != 0.0 )
                Calculator.enter( value );

        } while ( value != 0.0 );

        System.out.println( "Min: " + Calculator.getMin() );
        System.out.println("Max: " + Calculator.getMax() );
        System.out.println("Sum: " + Calculator.getSum() );
        System.out.println("Mean: " + Calculator.getMean() );
        System.out.println("Standard Deviation: " + Calculator.getStandardDeviation() );
        System.out.println("Count: " + Calculator.getCount() );

    }

}
