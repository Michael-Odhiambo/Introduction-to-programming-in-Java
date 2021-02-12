/**
 * Write a program that will evaluate simple expressions such as 17 + 3 and 3.14159 * 4.7.
 * The expressions are to be typed in by the user. The input always consists of a number,
 * followed by an operator, followed by another number. The operators that are allowed are
 * +, -, *, and /.
 */

import java.util.Scanner;

public class SimpleDivisors {

    public static void main( String[] args ) {

        Scanner stdin = new Scanner( System.in );
        double number1, number2;
        String operator;

        System.out.println( "Operators: +, -, *, /" );

        while ( true ) {
            System.out.print( "Number 1: " );
            number1 = stdin.nextDouble();

            if ( number1 == 0.0 ) {
                break;
            }
            System.out.print( "Operator: " );
            operator = stdin.next();

            System.out.print( "Number 2: " );
            number2 = stdin.nextDouble();

            double result;  // Store the result.
            result = 0;

            switch ( operator ) {

                case "+" :
                    result = number1 + number2;
                    break;
                case "-" :
                    result = number1 - number2;
                    break;
                case "*" :
                    result = number1 * number2;
                    break;
                case "/" :
                    if ( number2 == 0 ) {
                        System.out.println( "Zero division not defined." );
                        break;
                    }
                    result = number1 / number2;
                    break;
            }
            System.out.printf( "The result is: %s\n", result );
        }

    }
}
