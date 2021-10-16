package concept_study.algorithm.Graph.Lowest_Common_Ancestor;

import java.util.Vector;

public class LCA_for_a_Set_of_Nodes_in_a_Rooted_Tree {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-for-a-set-of-nodes-in-a-rooted-tree/

    // Time Complexity: O(N)
    // Space Complexity: O(N)

    // Set time 1 initially
    static int T = 1;

    static void dfs(int node, int parent, Vector<Integer>[] g, int[] level, int[] t_in, int[] t_out) {

        // Case for root node
        if (parent == -1) {
            level[node] = 1;
        } else {
            level[node] = level[parent] + 1;
        }

        // In-time for node
        t_in[node] = T;

        for (int adj : g[node]) {
            if (adj != parent) {
                T++;
                dfs(adj, node, g, level, t_in, t_out);
            }
        }

        T++;

        // Out-time for the node
        t_out[node] = T;
    }


    static int findLCA(int n, Vector<Integer>[] g, Vector<Integer> v) {

        int[] level = new int[n + 1];
        int[] t_in = new int[n + 1];
        int[] t_out = new int[n + 1];

        // Fill the level, in-time and out-time of all nodes
        dfs(1, -1, g, level, t_in, t_out);

        int mint = Integer.MAX_VALUE;
        int maxt = Integer.MIN_VALUE;
        int minv = -1;
        int maxv = -1;

        for (int i = 0; i < v.size(); i++) {

            // To find minimum in-time among all nodes in LCA set
            if (t_in[v.get(i)] < mint) {
                mint = t_in[v.get(i)];
                minv = v.get(i);
            }

            // To find maximum in-time among all nodes in LCA set
            if (t_out[v.get(i)] > maxt) {
                maxt = t_out[v.get(i)];
                maxv = v.get(i);
            }
        }

        // Node with same minimum  and maximum out time is LCA for the set
        if (minv == maxv)
            return minv;

        // Take the minimum level as level of LCA
        int lev = Math.min(level[minv], level[maxv]);
        int node = 0, l = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {

            // If i-th node is at a higher level than that of the minimum among
            // the nodes of the given set
            if (level[i] > lev)
                continue;

            // Compare in-time, out-time and level of i-th node
            // to the respective extremes among all nodes of the given set
            if (t_in[i] <= mint && t_out[i] >= maxt && level[i] > l) {
                node = i;
                l = level[i];
            }
        }

        return node;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 10;

        Vector<Integer>[] g = new Vector[n + 1];
        for (int i = 0; i < g.length; i++)
            g[i] = new Vector<Integer>();

        g[1].add(2);
        g[2].add(1);
        g[1].add(3);
        g[3].add(1);
        g[1].add(4);
        g[4].add(1);
        g[2].add(5);
        g[5].add(2);
        g[2].add(6);
        g[6].add(2);
        g[3].add(7);
        g[7].add(3);
        g[4].add(10);
        g[10].add(4);
        g[8].add(7);
        g[7].add(8);
        g[9].add(7);
        g[7].add(9);

        Vector<Integer> v = new Vector<>();
        v.add(7);
        v.add(3);
        v.add(8);

        System.out.print(findLCA(n, g, v) + "\n");
    }
}
