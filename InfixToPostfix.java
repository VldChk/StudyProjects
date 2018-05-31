package StackAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InfixToPostfix {

    private int n = 0;
    private Node first;

    private class Node {
        private String item;
        private Node next;
    }

    private String pop() {
        String item = first.item;
        first = first.next;
        n--;
        return item;
    }

    private String show() {
        String item = "";
        if (size_of_stack() > 0) {
            item = first.item;
        }
        return item;
    }

    private void push(String Item) {
        Node temp = first;
        first = new Node();
        first.item = Item;
        first.next = temp;
        n++;
    }

    private Boolean isOperator (char input) {
        return (input == '(') || (input == ')') || (input == '*') || (input == '/') || (input == '+') || (input == '-');
    }

    private Boolean isLowerPriority (String prev, char current) {

        if ((prev.compareTo("+") == 0 && current == '-') || (prev.compareTo("-") == 0 && current == '+')) {
            return true;
        } else if ((prev.compareTo("*") == 0 && current == '/') || (prev.compareTo("/") == 0 && current == '*')) {
            return true;
        } else if ((prev.compareTo("*") == 0 || prev.compareTo("/") == 0) && (current == '+' || current == '-')) {
            return true;
        } else {
            return false;
        }

    }

    private int size_of_stack () {
        return n;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        InfixToPostfix stack = new InfixToPostfix ();
        Boolean isBalanced = true;

        String input = scanner.next();

        char[] bracketArray = input.toCharArray();

        int size = input.length();

        StringBuffer postfix = new StringBuffer(input.length());

        int iterator = 0;
/*

Validating expression (a bit - only brackets)

 */
        while (iterator < size) {
            String nextItem = new StringBuilder().append(bracketArray[iterator]).toString();
            if (nextItem.compareTo("(") == 0 || nextItem.compareTo("[") == 0 || nextItem.compareTo("{") == 0 ) {
                stack.push(nextItem);
            } else if (nextItem.compareTo(")") == 0) {
                String prevItem = stack.pop();
                if (prevItem.compareTo("(") != 0) {
                    isBalanced = false;
                }
            } else if (nextItem.compareTo("}") == 0) {
                String prevItem = stack.pop();
                if (prevItem.compareTo("{") != 0) {
                    isBalanced = false;
                }
            }  else if (nextItem.compareTo("]") == 0) {
                String prevItem = stack.pop();
                if (prevItem.compareTo("[") != 0) {
                    isBalanced = false;
                }
            }
            iterator ++;
        }

        if (isBalanced == false ) {
            throw new java.lang.Error("Expression is not balanced");
        }

        iterator = 0;

        InfixToPostfix infix = new InfixToPostfix ();
/*

Converting infix into postfix

 */
        while (iterator < size) {
            if (!infix.isOperator(bracketArray[iterator])) {
                postfix.append(bracketArray[iterator]);
            } else if (bracketArray[iterator] == ')') {
                while (infix.show().toCharArray()[0] != '(')
                {
                    postfix.append(infix.pop());
                }
                String str = infix.pop();
            } else {

                while (infix.isLowerPriority(infix.show(), bracketArray[iterator])) {
                    postfix.append(infix.pop());
                }

                infix.push(new StringBuilder().append(bracketArray[iterator]).toString());

            }
            iterator ++;
        }

        while (infix.size_of_stack() > 0) {
            String curr = infix.pop();
            if (curr.compareTo("(")  != 0) {
                postfix.append(curr);
            }
        }

        System.out.println(postfix.toString());
/*

Just calculating result of expression using new postfix format

 */
        char[] postFixCalc = postfix.toString().toCharArray();

        iterator = 0;

        InfixToPostfix pstfix = new InfixToPostfix ();

        while (iterator < postfix.toString().length()) {
            if (!pstfix.isOperator(postFixCalc[iterator])) {
                pstfix.push(new StringBuilder().append(postFixCalc[iterator]).toString());
            } else {
                String curr = pstfix.pop();
                String prev = pstfix.pop();
                int result = 0;

                if (postFixCalc[iterator] == '+') {
                    result = (Integer.parseInt(prev) + Integer.parseInt(curr));
                } else if (postFixCalc[iterator] == '-') {
                    result = (Integer.parseInt(prev) - Integer.parseInt(curr));
                } else if (postFixCalc[iterator] == '*') {
                    result = (Integer.parseInt(prev) * Integer.parseInt(curr));
                } else if (postFixCalc[iterator] == '/') {
                    result = (Integer.parseInt(prev) / Integer.parseInt(curr));
                }

                pstfix.push(String.valueOf(result));
            }

            iterator ++;
        }

        System.out.println(pstfix.pop());


    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Boolean isEmpty () {
            return (st == null || !st.hasMoreTokens());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
