package concept_study.algorithm.Graph.Tree.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

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

        levelOrder(root);
    }

    // 낮은 레벨의 노드부터 순서대로 방문
    static void levelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur + " -> ");

            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }
    }
}
