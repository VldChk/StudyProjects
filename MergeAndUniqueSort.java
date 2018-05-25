import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeAndUniqueSort {

    static String[] Merge(String[] words, int f_start_p, int mid, int s_end_p)
    {
        String [] result = new String [s_end_p - f_start_p + 1];
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

    static String[] Uniqueness (String[] input)
    {
        int i = 1;
        for (int j = 1; j < input.length; j++)
        {
            if (input[j-1].compareTo(input [j]) < 0)
            {
                i++;
            }
        }

        String [] result = new String[i];

        result [0] = input[0];
        i = 1;

        for (int j = 1; j < input.length; j++)
        {
            if (input[j-1].compareTo(input [j]) < 0)
            {
                result[i] = input[j];
                i++;
            }
        }

        return result;
    }

    static String[] MergeSort (String[] words, int start_p, int end_p)
    {
        int mid_p = start_p + (end_p - start_p) / 2;
        if (end_p - start_p > 1)
        {
            MergeSort(words, start_p, mid_p);
            MergeSort(words,mid_p + 1, end_p);
        }

        return Merge(words, start_p, mid_p, end_p);
    }
	
	static String[] MainMergeSort (String[] input)
	{
		int start_p = 0;
		int end_p = input.length - 1;
		return Uniqueness(MergeSort(input, start_p, end_p));
	}

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int num_of_words = scanner.nextInt();
        String words[] = new String[num_of_words];
        for (int i = 0; i < num_of_words; i++)
        {
            words[i] = scanner.next();
        }

        String sorted[] = MainMergeSort(words);

        for (int i = 0; i < sorted.length; i++)
        {
            System.out.println(sorted[i]);
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
