package StanfordAlgorithms_Course1;

import java.util.Scanner;
/**
 * Stanford Algorithms Specialization
 * Course 1
 * Week 1
 *
 * Very straightforward multiplication
 */
public class Week1_StraightforwardMultiplication {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println(reader.nextBigInteger(10).multiply(reader.nextBigInteger(10)));
    }
}
