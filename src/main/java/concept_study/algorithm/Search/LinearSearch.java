package concept_study.algorithm.Search;

/**
 * In computer science, linear search or sequential search is a method for finding a target value within a list.
 * It sequentially checks each element of the list for the target value until a match is
 * found or until all the elements have been searched.
 * <p>
 * Worst-case performance      O(n)<br>
 * Best-case performance       O(1)<br>
 * Average performance         O(n)<br>
 * Worst-case space complexity O(1)<br>
 * <br>
 */
public class LinearSearch {
    // https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/search/LinearSearch.java

    static int find(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i])
                return i;
        }
        return Integer.MAX_VALUE;
    }
}






