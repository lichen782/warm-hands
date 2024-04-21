package cn.lich.itv.one50;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @author lich
 * @date 2024/2/6
 */
public class WordSearch {

    private String word;

    private char[][] board;

    private int[][] directions ={
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0},
    };

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                   return true;
                }
            }
        }

        return false;

    }

    private boolean dfs(int i, int j, int wordAt) {
        if (wordAt == word.length() - 1 && board[i][j] == word.charAt(wordAt)) {
            return true;
        }

        if (board[i][j] != word.charAt(wordAt)) {
            return false;
        }

        char origin = board[i][j];
        board[i][j] = '!';

        for (int[] dir: directions) {
            int ii = i + dir[0];
            int jj = j + dir[1];

            if (ii >= 0 && ii < board.length &&
                jj >= 0 && jj < board[0].length &&
                dfs(ii, jj, wordAt + 1)) {
                return true;
            }
        }

        board[i][j] = origin;

        return false;
    }

    public static void main(String[] args) {
        WordSearch w = new WordSearch();

        char[][] board ={
                {'A'}
        };

        System.out.println(w.exist(board, "A"));
    }
}
