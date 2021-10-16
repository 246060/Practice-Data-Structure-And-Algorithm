package concept_study.algorithm.Graph.Tree.Traversal;

public class PostOrder {

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

        System.out.println("PostOrder(Left -> Right -> Root) : ");
        postOrder(root);
        System.out.println("\n");
    }

    // Left -> Right -> Root
    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node + " -> ");
    }
}
