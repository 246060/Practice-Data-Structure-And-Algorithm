package solve_practice_problems.LeetCode.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_95_Unique_Binary_Search_Trees_2 {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {this.val = val;}

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateTrees(n));

        n = 1;
        System.out.println(generateTrees(n));
    }

    static public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return Collections.emptyList();

        return subTree(1, n);
    }

    private static List<TreeNode> subTree(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();

        if (l > r) {
            ans.add(null);
            return ans;
        }

        for (int root = l; root <= r; root++) {
            List<TreeNode> leftSubTrees = subTree(l, root - 1);
            List<TreeNode> rightSubTrees = subTree(root + 1, r);

            for (TreeNode leftSubTree : leftSubTrees) {
                for (TreeNode rightSubTree : rightSubTrees) {
                    TreeNode cur = new TreeNode(root);
                    cur.left = leftSubTree;
                    cur.right = rightSubTree;
                    ans.add(cur);
                }
            }
        }

        return ans;
    }
}
