import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vladyslav on 18.05.2018.
 */
public class MergeAndUniqueSort {

    static void Sort(String[] words, int start, int end)
    {
        for (int i = start; i < end; i++)
        {
            if (words[i].compareTo(words[i+1]) > 0)
            {
                String midRes = words[i+1];
                words[i+1] = words[i];
                words[i] = midRes;
            }
        }
    }

    static String[] Merge(String[] words, int f_start_p, int f_end_p, int s_start_p, int s_end_p)
    {
        String [] result = new String [s_end_p - f_start_p + 1];
        int k = f_start_p;
        int j = s_start_p;
        int i = f_start_p;
        while (k <= f_end_p || j <= s_end_p)
        {
            if (k > f_end_p)
            {
                result[i] = words[j];
                j++;
            } else if (j > s_end_p) {
                result[i] = words [k];
                k++;
            } else if (words[k].compareTo(words[j]) <= 0) {
                result[i] = words[k];
                k++;
            } else {
                result[i] = words[j];
                j++;
            }
            i++;
        }

        for (int id = f_start_p; id <= s_end_p; id++)
        {
            words[id] = result[id];
        }

        return words;
    }

    static String[] MergeSort (String[] words, int start_p, int end_p)
    {
        int mid_p = start_p + (end_p - start_p) / 2;
        if (end_p - start_p > 4)
        {
            MergeSort(words, start_p, mid_p);
            MergeSort(words,mid_p + 1, end_p);
        } else
        {
            Sort(words, start_p, mid_p);
            Sort(words, mid_p + 1, end_p);
        }

        return Merge(words, start_p, mid_p, mid_p+1, end_p);
    }
	
	static String[] MainMergeSort (String[] input)
	{
		String [] words = new String [input.length];
		int start_p = 0;
		int end_p = input.length - 1;
		return MergeSort(input, start_p, end_p);
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
