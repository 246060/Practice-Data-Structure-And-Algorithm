package concept_study.algorithm.sort.counting_sort;

import java.util.Arrays;

public class CountingSort1 {
    public static void main(String[] args) {

        int[] arr = {3, 5, 20, 3, 5, 10, 2, 4, 5, 2, 1};
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int n = arr.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 0, k = 0; i <= max; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    arr[k++] = i;
                }
            }
        }
    }
}
