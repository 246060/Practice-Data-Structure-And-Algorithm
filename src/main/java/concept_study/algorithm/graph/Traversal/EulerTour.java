package concept_study.algorithm.graph.Traversal;

import java.util.ArrayList;
import java.util.Stack;

// 오일러 투어 순회
// 전위, 중위, 후위 순회를 모두 합친 형태
public class EulerTour {
    // https://www.geeksforgeeks.org/euler-tour-binary-tree/

    // Root -> Left -> Root -> Right -> Root
    // 2n-1 nodes in Euler tour of a tree with n nodes

    // Time Complexity: O(2*N-1) where N is number of nodes in the tree.
    // Auxiliary Space : O(2*N-1) where N is number of nodes in the tree.

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() { return value + ""; }
    }

    public static void main(String[] args) {
        System.out.println("""
                
                       1
                     /   \\
                   2       3
                 /   \\
                4     5
                
                """);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Root -> Left -> Root -> Right -> Root\n");

        System.out.println("EulerTour Recusive : ");
        eulerTour_Recusive(root);
        System.out.println("\n");

        System.out.println("EulerTour Iterative : ");
        eulerTour_Iterative(root);
        System.out.println("\n");

        System.out.println("EulerTour Path Store : ");
        ArrayList<Node> paths = eulerTour(root, new ArrayList<>());
        System.out.println(paths);
    }

    // Root -> Left -> Root -> Right -> Root
    static void eulerTour_Recusive(Node node) {

        System.out.print(node + " -> ");

        if (node.left != null) {
            eulerTour_Recusive(node.left);
            System.out.print(node + " -> ");
        }

        if (node.right != null) {
            eulerTour_Recusive(node.right);
            System.out.print(node + " -> ");
        }
    }

    static void eulerTour_Iterative(Node node) {

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur + " -> ");

            if (cur.right != null) {
                stack.push(new Node(cur.value));
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(new Node(cur.value));
                stack.push(cur.left);
            }
        }
    }

    static ArrayList<Node> eulerTour(Node node, ArrayList<Node> paths) {

        paths.add(node);

        if (node.left != null) {
            eulerTour(node.left, paths);
            paths.add(node);
        }

        if (node.right != null) {
            eulerTour(node.right, paths);
            paths.add(node);
        }

        return paths;
    }
}
