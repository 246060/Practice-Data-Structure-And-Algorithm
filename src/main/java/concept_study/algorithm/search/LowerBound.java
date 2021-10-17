package concept_study.algorithm.search;

/**
 * Lower bound search concept.algorithm.
 * Lower bound is kind of binary search concept.algorithm but:
 * -If searched element doesn't exist function returns index of first element which is bigger than searched value.
 * -If searched element is bigger than any array element function returns first index after last element.
 * -If searched element is lower than any array element function returns index of first element.
 * -If there are many values equals searched value function returns first occurrence.
 * Behaviour for unsorted arrays is unspecified.
 * Complexity O(log n).
 */
public class LowerBound {
    // https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/search/LowerBound.java

    public static void main(String[] args) {
        LowerBound lb = new LowerBound();
        int[] a = {1, 2, 2, 3, 3, 3, 4, 6, 7};

        System.out.println(lb.lowerBound(a, a.length, 3));
    }

    // 특정 값보다 같거나 큰 값이 처음 나오는 위치
    int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        // note: 배열에 없는 큰수를 찾으려는 시도를 위해 length -1 이 아닌 length로 할당

        while (low < high) {
            int mid = (low + high) / 2;

            if (array[mid] >= value) {
                // 찾은 값이 같거나 더 크면 high를 mid로 down 시킨다.
                high = mid;
            } else {
                // 찾은 값이 더 작으면 low를 mid + 1 up 시킨다.
                low = mid + 1;
            }
        }

        return low;
    }
}






