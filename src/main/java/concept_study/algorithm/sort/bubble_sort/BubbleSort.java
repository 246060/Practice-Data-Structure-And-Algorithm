package concept_study.algorithm.sort.bubble_sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
