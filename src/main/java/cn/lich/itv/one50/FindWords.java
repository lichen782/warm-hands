package cn.lich.itv.one50;

import java.util.*;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * @author lich
 * @date 2024/1/31
 */
public class FindWords {

    class Node {
        boolean hasTerminate;
        Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }

    private Node root;

    private LinkedList<Character> path;

    private Set<Integer> visited;

    private Set<String> effectiveWord;

    private static final int[][] directions = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0},
    };

    private void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.hasTerminate = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for (String word : words) {
            insert(word);
        }

        path = new LinkedList<>();
        visited = new HashSet<>();
        effectiveWord = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return new ArrayList<>(effectiveWord);
    }

    private int posValue(char[][] board, int i, int j) {
        return i * board[0].length + j;
    }

    private void dfs(char[][] board, int i, int j, Node cur) {
        int posv = posValue(board, i, j);
        if (visited.contains(posv)) {
            return;
        }

        char cij = board[i][j];
        int index = cij - 'a';

        Node next = cur.children[index];

        if (next == null) {
            // 此路不通
            return;
        }

        path.add(cij);
        visited.add(posv);

        if (next.hasTerminate) {
            effectiveWord.add(
                    path.stream().collect(
                            StringBuilder::new,
                            StringBuilder::append,
                            StringBuilder::append).toString());
            next.hasTerminate = false;
        }

        for (int k = 0; k < directions.length; k++) {
            int ii = i + directions[k][0];
            int jj = j + directions[k][1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length) {
                dfs(board, ii, jj, next);
            }
        }

        path.removeLast();
        visited.remove(posv);

    }

    public static void main(String[] args) {
        FindWords f = new FindWords();
        char[][] board = {{'a','b','e'}, {'b','c','d'}};//{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"abcdeb"};
        List<String> l = f.findWords(board, words);
        for (String w: l) {
            System.out.print(w + ",");
        }
    }
}
