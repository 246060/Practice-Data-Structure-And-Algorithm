package concept_study.algorithm.Basic.Sort;

import java.util.Arrays;

public class Counting_Sort {
    // https://www.geeksforgeeks.org/counting-sort/

    public static void main(String[] args) {

        char[] arr = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};

        System.out.println("Given Array");
        print(arr);

        sort(arr);

        System.out.println("\nSorted array");
        print(arr);
    }


    static void sort(char[] arr) {

        int n = arr.length;

        // The output character array that will have sorted arr
        char[] output = new char[n];

        // Create a count array to store count of inidividul characters and initialize count array as 0
        int[] count = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual position of this character in output array
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        // Build the output character array To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }

    // A utility function to print an array
    static void print(char[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
