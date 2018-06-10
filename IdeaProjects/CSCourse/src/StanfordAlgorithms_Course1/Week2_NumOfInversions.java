package StanfordAlgorithms_Course1;

import java.io.*;

/**
 * Stanford Algorithms Specialization
 * Course 1
 * Week 2
 *
 * Count of inversions
 *
 */
public class Week2_NumOfInversions {

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

    static Integer[] MergeSort (Integer[] words, int start_p, int end_p)
    {
        int mid_p = start_p + (end_p - start_p) / 2;
        if (end_p - start_p > 1)
        {
            MergeSort(words, start_p, mid_p);
            MergeSort(words,mid_p + 1, end_p);
        }

        return Merge(words, start_p, mid_p, end_p);
    }

    static Integer[] MainMergeSort (Integer[] input)
    {
        int start_p = 0;
        int end_p = input.length - 1;
        return MergeSort(input, start_p, end_p);
    }

    public static void main(String[] args) throws java.lang.Exception {

        Integer [] array = new Integer[100000];
        int i = 0;

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vladyslav\\IdeaProjects\\CSCourse\\src\\StanfordAlgorithms_Course1\\Test_Data\\input\\Week2_IntegerArray.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
                array [i] = Integer.parseInt(line);
                line = br.readLine();
                i++;
            }
        } finally {
            br.close();
        }

        Integer [] output = MainMergeSort(array);

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter("C:\\Users\\Vladyslav\\IdeaProjects\\CSCourse\\src\\StanfordAlgorithms_Course1\\Test_Data\\output\\Week2_IntegerArray_Out.txt");
            bw = new BufferedWriter(fw);
            for (int j =0; j < output.length; j++) {
                bw.write(String.valueOf(output[j]).concat("\n"));
            }

            System.out.println(Inversions);
            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }
}
