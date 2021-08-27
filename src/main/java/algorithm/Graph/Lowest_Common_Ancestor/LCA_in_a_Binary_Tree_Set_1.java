package algorithm.Graph.Lowest_Common_Ancestor;

import java.util.ArrayList;
import java.util.List;

public class LCA_in_a_Binary_Tree_Set_1 {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Method_3 {

        /* Driver program to test above functions */
        public static void main(String[] args) {

            Method_3 tree = new Method_3();

            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);

            Node lca = tree.findLCA(4, 5);
            if (lca != null)
                System.out.println("LCA(4, 5) = " + lca.data);
            else
                System.out.println("Keys are not present");

            lca = tree.findLCA(4, 10);
            if (lca != null)
                System.out.println("LCA(4, 10) = " + lca.data);
            else
                System.out.println("Keys are not present");
        }

        // Root of the Binary Tree
        Node root;
        static boolean v1 = false;
        static boolean v2 = false;

        // This function returns pointer to LCA of two given values n1 and n2.
        // v1 is set as true by this function if n1 is found
        // v2 is set as true by this function if n2 is found
        Node findLCAUtil(Node node, int n1, int n2) {

            // Base case
            if (node == null)
                return null;

            //Store result in temp, in case of key match so that we can search for other key also.
            Node temp = null;

            // If either n1 or n2 matches with root's key, report the presence
            // by setting v1 or v2 as true and return root (Note that if a key
            // is ancestor of other, then the ancestor key becomes LCA)
            if (node.data == n1) {
                v1 = true;
                temp = node;
            }

            if (node.data == n2) {
                v2 = true;
                temp = node;
            }

            // Look for keys in left and right subtrees
            Node left_lca = findLCAUtil(node.left, n1, n2);
            Node right_lca = findLCAUtil(node.right, n1, n2);

            if (temp != null)
                return temp;

            // If both of the above calls return Non-NULL, then one key
            // is present in once subtree and other is present in other,
            // So this node is the LCA
            if (left_lca != null && right_lca != null)
                return node;

            // Otherwise check if left subtree or right subtree is LCA
            return (left_lca != null) ? left_lca : right_lca;
        }

        // Finds lca of n1 and n2 under the subtree rooted with 'node'
        Node findLCA(int n1, int n2) {

            v1 = false;
            v2 = false;
            Node lca = findLCAUtil(root, n1, n2);

            if (v1 && v2)
                // Return LCA only if both n1 and n2 are present in tree
                return lca;

            return null;
        }


    }

    static class Method_2 {

        /* Driver program to test above functions */
        public static void main(String args[]) {
            Method_2 tree = new Method_2();

            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);

            System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data);
            System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data);
            System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
            System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
        }

        // Root of the Binary Tree
        Node root;

        Node findLCA(int n1, int n2) {
            return findLCA(root, n1, n2);
        }

        // This function returns pointer to LCA of two given values n1 and n2.
        // This function assumes that n1 and n2 are present in Binary Tree
        Node findLCA(Node node, int n1, int n2) {
            // Base case
            if (node == null)
                return null;

            // If either n1 or n2 matches with root's key, report the presence
            // by returning root (Note that if a key is ancestor of other, then the ancestor key becomes LCA
            if (node.data == n1 || node.data == n2)
                return node;

            // Look for keys in left and right subtrees
            Node left_lca = findLCA(node.left, n1, n2);
            Node right_lca = findLCA(node.right, n1, n2);

            // If both of the above calls return Non-NULL, then one key is present in once subtree
            // and other is present in other, So this node is the LCA
            if (left_lca != null && right_lca != null)
                return node;

            // Otherwise check if left subtree or right subtree is LCA
            return (left_lca != null) ? left_lca : right_lca;
        }
    }


    static class Method_1 { //  (By Storing root to n1 and root to n2 paths)

        // Following is a simple O(n) algorithm to find LCA of n1 and n2.
        // 1) Find a path from the root to n1 and store it in a vector or array.
        // 2) Find a path from the root to n2 and store it in another vector or array.
        // 3) Traverse both paths till the values in arrays are the same. Return the common element just before the mismatch.

        // * Time Complexity:
        // The time complexity of the above solution is O(n).
        // The tree is traversed twice, and then path arrays are compared.

        // Driver code
        public static void main(String[] args) {
            Method_1 tree = new Method_1();

            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);

            System.out.println("LCA(4, 5): " + tree.findLCA(4, 5));
            System.out.println("LCA(4, 6): " + tree.findLCA(4, 6));
            System.out.println("LCA(3, 4): " + tree.findLCA(3, 4));
            System.out.println("LCA(2, 4): " + tree.findLCA(2, 4));

        }

        Node root;
        private List<Integer> path1 = new ArrayList<>();
        private List<Integer> path2 = new ArrayList<>();

        // Finds the path from root node to given root of the tree.
        int findLCA(int n1, int n2) {
            path1.clear();
            path2.clear();

            return findLCAInternal(root, n1, n2);
        }

        private int findLCAInternal(Node root, int n1, int n2) {

            if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
                System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
                System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
                return -1;
            }

            int i;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                if (!path1.get(i).equals(path2.get(i)))
                    break;
            }

            return path1.get(i - 1);
        }

        // Finds the path from root node to given root of the tree, Stores the
        // path in a vector path[], returns true if path exists otherwise false
        private boolean findPath(Node root, int n, List<Integer> path) {

            // base case
            if (root == null)
                return false;

            // Store this node.
            // The node will be removed if not in path from root to n.
            path.add(root.data);

            if (root.data == n)
                return true;

            if (root.left != null && findPath(root.left, n, path)) return true;
            if (root.right != null && findPath(root.right, n, path)) return true;

            // If not present in subtree rooted with root, remove root from path[] and return false
            path.remove(path.size() - 1);

            return false;
        }
    }
}
