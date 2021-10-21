package concept_study.algorithm.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination1 {
    public static void main(String[] args) {

        int n = 5;
        List<int[]> list = generate(11, 3);
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static List<int[]> generate(int n, int r) {
        if (r == 0) {
            return new ArrayList<>(List.of(new int[]{}));
        }

        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }
}
