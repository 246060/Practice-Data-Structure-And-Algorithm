package concept_study.algorithm.graph.Lowest_Common_Ancestor;

import java.util.HashMap;
import java.util.Map;

public class LCA_in_a_Binary_Tree__Set_2_Using_Parent_Pointer {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/

    static class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            left = right = parent = null;
        }
    }

    static class Case1 {

        public static void main(String[] args) {
            Case1 tree = new Case1();

            tree.root = tree.insert(tree.root, 20);
            tree.root = tree.insert(tree.root, 8);
            tree.root = tree.insert(tree.root, 22);
            tree.root = tree.insert(tree.root, 4);
            tree.root = tree.insert(tree.root, 12);
            tree.root = tree.insert(tree.root, 10);
            tree.root = tree.insert(tree.root, 14);

            tree.n1 = tree.root.left.right.left;
            tree.n2 = tree.root.left;
            tree.lca = tree.LCA(tree.n1, tree.n2);

            // Output:
            // LCA of 10 and 8 is 8
            System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key + " is " + tree.lca.key);
        }

        Node root, n1, n2, lca;

        /* A utility function to insert a new node with given key in Binary Search Tree */
        Node insert(Node node, int key) {

            /* If the tree is empty, return a new node */
            if (node == null)
                return new Node(key);

            /* Otherwise, recur down the tree */
            if (key < node.key) {
                node.left = insert(node.left, key);
                node.left.parent = node;
            } else if (key > node.key) {
                node.right = insert(node.right, key);
                node.right.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }

        // To find LCA of nodes n1 and n2 in Binary Tree
        Node LCA(Node n1, Node n2) {

            // Creata a map to store ancestors of n1
            Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>();

            // Insert n1 and all its ancestors in map
            while (n1 != null) {
                ancestors.put(n1, Boolean.TRUE);
                n1 = n1.parent;
            }

            // Check if n2 or any of its ancestors is in map.
            while (n2 != null) {
                if (ancestors.containsKey(n2) != ancestors.isEmpty())
                    return n2;
                n2 = n2.parent;
            }

            return null;
        }
    }

    static class Case2 {

        public static void main(String[] args) {
            Case2 tree = new Case2();

            tree.root = tree.insert(tree.root, 20);
            tree.root = tree.insert(tree.root, 8);
            tree.root = tree.insert(tree.root, 22);
            tree.root = tree.insert(tree.root, 4);
            tree.root = tree.insert(tree.root, 12);
            tree.root = tree.insert(tree.root, 10);
            tree.root = tree.insert(tree.root, 14);

            tree.n1 = tree.root.left.right.left;
            tree.n2 = tree.root.right;
            tree.lca = tree.LCA(tree.n1, tree.n2);

            // Output :
            // LCA of 10 and 22 is 20
            System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key + " is " + tree.lca.key);
        }

        Node root, n1, n2, lca;

        /* A utility function to insert a new node with given key in Binary Search Tree */
        Node insert(Node node, int key) {

            /* If the tree is empty, return a new node */
            if (node == null)
                return new Node(key);

            /* Otherwise, recur down the tree */
            if (key < node.key) {
                node.left = insert(node.left, key);
                node.left.parent = node;
            } else if (key > node.key) {
                node.right = insert(node.right, key);
                node.right.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }

        // A utility function to find depth of a node (distance of it from root)
        int depth(Node node) {
            int d = -1;
            while (node != null) {
                ++d;
                node = node.parent;
            }
            return d;
        }

        // To find LCA of nodes n1 and n2 in Binary Tree
        Node LCA(Node n1, Node n2) {

            // Find depths of two nodes and differences
            int d1 = depth(n1), d2 = depth(n2);
            int diff = d1 - d2;

            // If n2 is deeper, swap n1 and n2
            if (diff < 0) {
                Node temp = n1;
                n1 = n2;
                n2 = temp;
                diff = -diff;
            }

            // Move n1 up until it reaches the same level as n2
            while (diff-- != 0)
                n1 = n1.parent;

            // Now n1 and n2 are at same levels
            while (n1 != null && n2 != null) {
                if (n1 == n2)
                    return n1;
                n1 = n1.parent;
                n2 = n2.parent;
            }
            return null;
        }
    }
}
