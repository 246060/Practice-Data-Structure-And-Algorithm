package concept_study.algorithm.Graph.Tree.Traversal;

public class InOrder {

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

        System.out.println("InOrder(Left -> Root -> Right) : ");
        inOrder(root);
    }

    // Left -> Root -> Right
    static void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node + " -> ");
        inOrder(node.right);
    }
}
