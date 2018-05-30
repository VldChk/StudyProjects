import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

/* Idea of this simple class is just non-recursive Binary Search */

public class BinarySearch {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        String search = scanner.next();
        // this string could be replaced with reading from stream or file, gonna do generator soon
        String words[] = {"aa", "ab", "bb", "bc", "cc", "cd", "kl", "mm", "nn", "oo", "p", "qrt", "rt", "ww", "yy", "zz"};

        int length = words.length;

        int startP = 0;
        int endP = length - 1;

        int middle ;
        boolean isFound = false;

        int Result = -1;

        while (startP <= endP && !isFound)
        {
            middle = startP + (endP - startP) / 2;
            if (words[middle].compareTo(search) > 0)
            {
                endP = middle - 1;
            } else if (words[middle].compareTo(search) < 0)
            {
                startP = middle + 1;
            } else {
                Result = middle;
                isFound = true;
            }
        }

        System.out.println(isFound);
        System.out.println(Result);
        System.out.println(1 / 2);
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
