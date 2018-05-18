import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/**
 * Created by Vladyslav on 18.05.2018.
 */
public class MergeAndUniqueSort {

    static boolean Sort(int start, int end)
	{
		if (start >= end) 
		{
			return true;
		} else if (start + 1 < end)
		{
			return false;
		} else 
		{
			if words[start].compareTo(words[end]) < 0
			{
				String midRes = words[end];
				words[end] = words[start];
				words[start] = midRes;
			}
		}
	}
	
	static String[] MergeSort (String[] input)
	{
		String [] words = input;
		
	}

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int num_of_words = scanner.nextInt();
        String words[] = new String[num_of_words];
        for (int i = 0; i < num_of_words; i++)
        {
            words[i] = scanner.next();
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
