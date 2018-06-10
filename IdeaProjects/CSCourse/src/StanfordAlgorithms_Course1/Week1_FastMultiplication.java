package StanfordAlgorithms_Course1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Stanford Algorithms Specialization
 * Course 1
 * Week 1
 *
 * Fast multiplication
 *
 * In fact it's not so fast because String is extremely slow data type in Java, but still I am practicing algorithm itself
 */
public class Week1_FastMultiplication {


    private static char [] reverse (char[] input) {
        char [] output = new char[input.length];
        int j = 0;

        for (int i = input.length - 1; i >=0; i--) {
            output[j] = input[i];
            j++;
        }

        return output;
    }

    private static int TrimZeroPos (char[] input) {
        int i = 0;
        while (i < input.length && input [i] == '0' ) {
            i++;
        }

        return Math.min(i, input.length - 1);
    }

    private static String GenerateZeros (int length) {
        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            result[i] = '0';
        }

        return String.valueOf(result);
    }

    private static String StringAdd (String a, String b) {
        char [] first = reverse(a.toCharArray());
        char [] second = reverse(b.toCharArray());

        char [] result = new char[Math.max(first.length, second.length)];
        int i = 0;

        boolean AddOne = false;
        int tmp = 0;

        while (i < Math.min(first.length, second.length)) {
            if (AddOne) {
                tmp =  Integer.parseInt(String.valueOf(first[i])) +  Integer.parseInt(String.valueOf(second[i])) + 1;
            } else {
                tmp =  Integer.parseInt(String.valueOf(first[i])) +  Integer.parseInt(String.valueOf(second[i]));
            }

            if (tmp > 9) {
                result [i] = (char)( (tmp - 10) + '0');
                AddOne = true;
            } else {
                result [i] = (char) ( tmp + '0');
                AddOne = false;
            }

            i++;
        }

        while (i < first.length ) {
            if (AddOne) {
                tmp =  Integer.parseInt(String.valueOf(first[i])) + 1;
            } else {
                tmp =  Integer.parseInt(String.valueOf(first[i]));
            }

            if (tmp > 9) {
                result [i] = (char) ( (tmp - 10) + '0');
                AddOne = true;
            } else {
                result [i] = (char) ( tmp + '0');
                AddOne = false;
            }

            i++;
        }

        while (i < second.length ) {
            if (AddOne) {
                tmp =  Integer.parseInt(String.valueOf(second[i])) + 1;
            } else {
                tmp =  Integer.parseInt(String.valueOf(second[i]));
            }

            if (tmp > 9) {
                result [i] = (char) ( (tmp - 10) + '0');
                AddOne = true;
            } else {
                result [i] = (char) ( tmp + '0');
                AddOne = false;
            }

            i++;
        }

        if (AddOne) {
            return "1".concat(String.valueOf(reverse(result)));
        } else {
            return String.valueOf(reverse(result));
        }

    }

    private static String StringMinus (String a, String b) {
        char [] first = reverse(a.toCharArray());
        char [] second = reverse(b.toCharArray());

        char [] result = new char[Math.max(first.length, second.length)];
        int i = 0;

        boolean MinusOne = false;
        int tmp = 0;

        while (i < Math.min(first.length, second.length)) {
            int f = Integer.parseInt(String.valueOf(first[i]));

            if (MinusOne) {
                f = f-1;
            }

            if (f < 0) {
                f = 9;
            }
            if (f < Integer.parseInt(String.valueOf(second[i]))) {
                tmp =  10 + f - Integer.parseInt(String.valueOf(second[i]));
                MinusOne = true;
            } else {
                tmp =  f -  Integer.parseInt(String.valueOf(second[i]));
                if (Integer.parseInt(String.valueOf(first[i])) - 1 < 0 && MinusOne) {
                    MinusOne = true;
                } else {
                    MinusOne = false;
                }
            }

            result [i] = (char) ( tmp + '0');
            i++;
        }

        while (i < first.length ) {
            if (MinusOne) {
                tmp =  Integer.parseInt(String.valueOf(first[i])) - 1;
            } else {
                tmp =  Integer.parseInt(String.valueOf(first[i]));
            }

            if (tmp < 0) {
                result [i] = (char) ( 9 + '0');
                MinusOne = true;
            } else {
                result [i] = (char) ( tmp + '0');
                MinusOne = false;
            }

            i++;
        }

        while (i < second.length ) {
            if (MinusOne) {
                tmp =  Integer.parseInt(String.valueOf(first[i])) - 1;
            } else {
                tmp =  Integer.parseInt(String.valueOf(first[i]));
            }

            if (tmp < 0) {
                result [i] = (char) ( 9 + '0');
                MinusOne = true;
            } else {
                result [i] = (char) ( tmp + '0');
                MinusOne = false;
            }

            i++;
        }
        result = reverse(result);

        return String.valueOf(result).substring(TrimZeroPos(result));

    }

    private static String FastMultiplication (String first_n, String second_n) {
        if (first_n.length() > 3 && second_n.length() > 3) {
            int first_length = first_n.length();
            int first_mid = (int) Math.ceil((double) first_length / 2.0);
            int second_length = second_n.length();
            int second_mid = (int) Math.ceil((double) second_length / 2.0);

            String ac = FastMultiplication(first_n.substring(0, first_mid), second_n.substring(0, second_mid));
            String bd = FastMultiplication(first_n.substring(first_mid), second_n.substring(second_mid));

            String ad_bc = StringMinus(StringMinus(FastMultiplication(StringAdd(first_n.substring(0, first_mid), first_n.substring(first_mid )), StringAdd(second_n.substring(0, second_mid), second_n.substring(second_mid ))), ac), bd);

            int n_power = Math.max(first_length, second_length);

            return StringAdd(StringAdd(ac.concat(GenerateZeros(n_power - n_power % 2)), ad_bc.concat(GenerateZeros((n_power - n_power % 2)/2))), bd);

        } else {
            return String.valueOf(Integer.parseInt(first_n) * Integer.parseInt(second_n));
        }
    }

    private static String FastMultiplication_new (String first_n, String second_n) {
        if (first_n.length() > 3 && second_n.length() > 3) {
            int first_length = first_n.length();
            int first_mid = (int) Math.ceil((double) first_length / 2.0);
            int second_length = second_n.length();
            int second_mid = (int) Math.ceil((double) second_length / 2.0);

            String ac = FastMultiplication(first_n.substring(0, first_mid), second_n.substring(0, second_mid));
            String bd = FastMultiplication(first_n.substring(first_mid), second_n.substring(second_mid));

            String ad_bc = StringMinus(StringMinus(FastMultiplication(StringAdd(first_n.substring(0, first_mid), first_n.substring(first_mid )), StringAdd(second_n.substring(0, second_mid), second_n.substring(second_mid ))), ac), bd);

            int n_power ;
            if (first_n.length() != second_n.length()) {
                if (Integer.parseInt(first_n.substring(0, 1)) * Integer.parseInt(second_n.substring(0, 1)) < 10) {
                    n_power = Math.max(first_length, second_length) + 1;
                } else {
                    n_power = Math.max(first_length, second_length);
                }
            } else {
                n_power = Math.max(first_length, second_length);
            }

            return StringAdd(StringAdd(ac.concat(GenerateZeros(n_power - n_power % 2)), ad_bc.concat(GenerateZeros(n_power/2))), bd);

        } else {
            return String.valueOf(Integer.parseInt(first_n) * Integer.parseInt(second_n));
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner reader = new Scanner(System.in);

        //String first_n = reader.next();
        //String second_n = reader.next();

        //BigDecimal first = new BigDecimal(first_n);
        //BigDecimal second = new BigDecimal(second_n);

        //Integer f_i = Integer.parseInt(first_n);
        //Integer s_i = Integer.parseInt(second_n);

        //System.out.println(FastMultiplication(first_n, second_n));

        //System.out.println(first.multiply(second));

        boolean check = true;
        int cnt = 1;

        while (cnt < 1001 ) {
            int num_of_digits = (int) (Math.random() * 10);
            double random = Math.random();
            BigInteger first_random = BigDecimal.valueOf(random).multiply(new BigDecimal("1".concat(GenerateZeros(num_of_digits)))).toBigInteger();
            //num_of_digits = (int) (Math.random() * 10);
            random = Math.random();
            BigInteger second_random = BigDecimal.valueOf(random).multiply(new BigDecimal("1".concat(GenerateZeros(num_of_digits)))).toBigInteger();

            long startTime = System.currentTimeMillis();

            String classical_calc = first_random.multiply(second_random).toString();

            long endTime = System.currentTimeMillis();

            double run_time_classical = (double) (endTime - startTime) / (1000);

            startTime = System.currentTimeMillis();

            String nonclassical_calc = FastMultiplication(first_random.toString(), second_random.toString());

            endTime = System.currentTimeMillis();

            double run_time_non_classical = (double) (endTime - startTime) / (1000);

            if (classical_calc.compareTo(nonclassical_calc) != 0)
            {
                check = false;
                System.out.println("=====-=====");
                System.out.println("===== OUTPUT =====");
                System.out.println("FAIL");
                System.out.println(first_random.toString());
                System.out.println(second_random.toString());
                System.out.println(classical_calc);
                System.out.println(nonclassical_calc);
            }

            if (cnt % 1000 == 0) {
                System.out.println("Successfully check #".concat(String.valueOf(cnt)));
            }

            cnt ++;

        }


    }


}

