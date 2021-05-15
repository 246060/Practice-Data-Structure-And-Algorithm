package algorithm.Search;

/**
 * In computer science, linear search or sequential search is a method for finding a target value within a list. It sequentially checks each element of the list for the target value until a match is
 * found or until all the elements have been searched.
 * <p>
 * Worst-case performance      O(n)<br>
 * Best-case performance       O(1)<br>
 * Average performance         O(n)<br>
 * Worst-case space complexity O(1)<br>
 * <br>
 * https://en.wikipedia.org/wiki/Linear_search
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class LinearSearch {
    // https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/search/LinearSearch.java

    public static final int find(int value, int[] array) {

        for (int i = 0; i < array.length; i++) {
            int iValue = array[i];

            if (value == iValue)
                return i;
        }

        return Integer.MAX_VALUE;
    }
}






