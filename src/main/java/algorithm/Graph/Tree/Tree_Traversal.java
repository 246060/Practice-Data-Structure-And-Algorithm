package algorithm.Graph.Tree;

public class Tree_Traversal {

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
        System.out.println("\n");

        System.out.println("PreOrder(Root -> Left -> Right) : ");
        preOrder(root);
        System.out.println("\n");

        System.out.println("PostOrder(Left -> Right -> Root) : ");
        postOrder(root);
    }

    // Left -> Root -> Right
    static void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node + " -> ");
        inOrder(node.right);
    }

    // Root -> Left -> Right
    static void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node + " -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Left -> Right -> Root
    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node + " -> ");
    }


}
