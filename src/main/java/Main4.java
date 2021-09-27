import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main4 {
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {

        st.push(5);
        decompose();
    }

    static void decompose() {
        while (true) {
            System.out.println(st.toString());

            int tmp = st.pop();
            if (tmp != 1) {
                st.push(tmp - 1);
                st.push(1);
            } else {
                int sum = 2;
                for (; !st.isEmpty() && st.peek() == 1; st.pop()) {
                    sum++;
                }
                if (st.isEmpty()) {
                    break;
                }

                int pivot = st.pop() - 1;
                st.push(pivot);
                while (sum > pivot) {
                    st.push(pivot);
                    sum -= pivot;
                }
                st.push(sum);
            }
        }
    }


}
