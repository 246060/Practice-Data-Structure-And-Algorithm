package data_structure.Graph.Tree.Trie;

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

    // https://www.baeldung.com/trie-java#3-deleting-an-element
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(Node cur, String word, int index) {

        // end of word
        if (index == word.length()) {
            if (cur.isWord) {
                cur.isWord = false;
                return cur.children.isEmpty();
            } else {
                return false;
            }
        }

        String s = String.valueOf(word.charAt(index));
        Node next = cur.children.get(s);
        if (next == null) {
            return false;
        }

        // Recursive DFS
        boolean canDelete
                // 현재 인덱스 글자의 하위 컨테이너가 비워졌는지
                = delete(next, word, index + 1)

                // 현재 인덱스 글자가 단어의 끝인지.
                && !next.isWord;


        if (canDelete) {
            cur.children.remove(s);
            return cur.children.isEmpty();
        }

        return false;
    }
}
