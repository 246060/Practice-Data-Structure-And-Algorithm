package concept_study.algorithm.graph.Lowest_Common_Ancestor;

import java.util.ArrayList;
import java.util.List;

public class LCA_any_number_of_nodes_in_Binary_Tree {
    // https://www.geeksforgeeks.org/least-common-ancestor-of-any-number-of-nodes-in-binary-tree/

    public static void main(String[] args) {

        // Creation of Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right = new Node(5);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right = new Node(7);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        // Key Nodes for LCA
        ArrayList<Integer> keyNodes = null;

        System.out.print("LCA of nodes 12, 14, 15 is node ");
        keyNodes = new ArrayList(List.of(12, 14, 15));
        System.out.println(lcaOfNodes(root, keyNodes).data); // 3

        System.out.print("LCA of nodes 3, 14, 15 is node ");
        keyNodes = new ArrayList(List.of(3, 14, 15));
        System.out.println(lcaOfNodes(root, keyNodes).data); // 3

        System.out.print("LCA of nodes 6, 7, 15 is node ");
        keyNodes = new ArrayList(List.of(6, 7, 15));
        System.out.println(lcaOfNodes(root, keyNodes).data); // 3

        System.out.print("LCA of nodes 5, 13, 14, 15 is node ");
        keyNodes = new ArrayList(List.of(5, 13, 14));
        System.out.println(lcaOfNodes(root, keyNodes).data); // 1

        System.out.print("LCA of nodes 6, 12 is node ");
        keyNodes = new ArrayList(List.of(6, 12));
        System.out.println(lcaOfNodes(root, keyNodes).data); // 6
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static ArrayList<Node> ancestors;

    // Function to find Least Common Ancestors of N number of nodes
    static Node lcaOfNodes(Node root, ArrayList<Integer> keyNodes) {

        // Create a new list for capturing all the ancestors of the given nodes
        ArrayList<Node> ancestors = new ArrayList<>();

        // Initially there is No Matching Nodes
        int matchingNodes = 0;
        getKeysCount(root, keyNodes, matchingNodes, ancestors);

        // First Node in the Ancestors list is the Least Common Ancestor of Given keyNodes
        return ancestors.get(0);
    }

    static int getKeysCount(Node root, ArrayList<Integer> keyNodes, int matchingNodes, ArrayList<Node> ancestors) {

        // Base Case. When root is Null
        if (root == null)
            return 0;

        // Search for left and right subtree for matching child Key Node.
        int tmpMatchingNodes = matchingNodes;
        matchingNodes += getKeysCount(root.left, keyNodes, tmpMatchingNodes, ancestors);
        matchingNodes += getKeysCount(root.right, keyNodes, tmpMatchingNodes, ancestors);

        // Condition to check if Root Node is also in Key Node
        if (keyNodes.contains(root.data))
            matchingNodes++;

        // Condition when matching Nodes is equal to the Key Nodes found
        if (matchingNodes == keyNodes.size())
            ancestors.add(root);

        return matchingNodes;
    }
}