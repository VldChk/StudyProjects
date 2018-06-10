package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * SPOJ Problem : INVCNT
 *
 */
public class INVCNT {

    public static long Inversions = 0;

    static Integer[] Merge(Integer[] words, int f_start_p, int mid, int s_end_p)
    {
        Integer [] result = new Integer [s_end_p - f_start_p + 1];
        int k = f_start_p;
        int j = mid + 1;
        int i = 0;
        while (k <= mid && j <= s_end_p)
        {
            if (words[k].compareTo(words[j]) <= 0) {
                result[i] = words[k];
                k++;
            } else {
                result[i] = words[j];
                Inversions = Inversions + (mid - k + 1);
                j++;
            }
            i++;
        }

        while (k <= mid)
        {
            result[i] = words[k];
            i++;
            k++;
        }

        while (j <= s_end_p)
        {
            result[i] = words[j];
            i++;
            j++;
        }

        i = 0;

        for (int id = f_start_p; id <= s_end_p; id++)
        {
            words[id] = result[i];
            i++;
        }

        return words;
    }

    static Integer [] MergeSort (Integer[] words, int start_p, int end_p)
    {
        int mid_p = start_p + (end_p - start_p) / 2;
        if (end_p - start_p > 1)
        {
            MergeSort(words, start_p, mid_p);
            MergeSort(words,mid_p + 1, end_p);
        }

         return Merge(words, start_p, mid_p, end_p);
    }

    static Integer [] MainMergeSort (Integer[] input)
    {
        int start_p = 0;
        int end_p = input.length - 1;
        return MergeSort(input, start_p, end_p);
    }

    public static void main(String[] args) throws Exception {

        FastScanner scanner = new FastScanner(System.in);

        int num_of_arrays = scanner.nextInt();


        for (int k = 1; k <= num_of_arrays; k++) {

            int size_of_array = scanner.nextInt();

            Integer[] input = new Integer[size_of_array];

            for (int i = 0; i < size_of_array; i++) {
                input[i] = Integer.parseInt(scanner.next());
            }

            Inversions = 0;

            Integer[] output = MainMergeSort(input);

            System.out.println(Inversions);

        }

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
