package StackAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StackToCheckBrackets {
    private int n ;
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

    private void push(String Item) {
        Node temp = first;
        first = new Node();
        first.item = Item;
        first.next = temp;
        n++;
    }

    private int size_of_stack () {
        return n;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        StackToCheckBrackets stack = new StackToCheckBrackets ();
        Boolean isBalanced = true;
        
        String input = scanner.next();

        char[] bracketArray = input.toCharArray();
        
        int size = input.length();
        
        int iterator = 0;

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

        System.out.println (isBalanced);
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
