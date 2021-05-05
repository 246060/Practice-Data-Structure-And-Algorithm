package data_structure.Trie;

import java.util.HashMap;

public class Trie {

    private final Node root = new Node();

    private static class Node {
        HashMap<String, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    public void insert(String word) {
        Node cur = root;
        for (String split : word.split("")) {
            if (cur.children.containsKey(split)) {
                cur = cur.children.get(split);
                continue;
            }
            Node nextNode = new Node();
            cur.children.put(split, nextNode);
            cur = nextNode;
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    private Node getNode(String word) {
        Node cur = this.root;
        for (String s : word.split("")) {
            if (!cur.children.containsKey(s))
                return null;
            cur = cur.children.get(s);
        }
        return cur;
    }

    public boolean startWith(String prefix) {
        return getNode(prefix) != null;
    }
}
