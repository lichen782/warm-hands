package cn.lich.itv.one50;

import cn.lich.itv.utils.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * @author lich
 * @date 2024/1/27
 */
public class SurroundAreas {

    private static final char X = 'X';
    private static final char O = 'O';

    private int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    private Set<Character> edgeIndexes;

    private int islandIndex = 0;

    public void solve(char[][] board) {
        edgeIndexes = new HashSet<>();
        islandIndex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == O) {
                    islandIndex++;
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (edgeIndexes.contains(board[i][j])) {
                    board[i][j] = O;
                } else if (board[i][j] != X) {
                    board[i][j] = X;
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] != O) {
            return;
        }

        board[i][j] = (char)('0' + islandIndex);

        if (atEdges(board, i, j)) {
            edgeIndexes.add(board[i][j]);
        }

        for (int k = 0; k < directions.length; k++) {
            int ii = i + directions[k][0];
            int jj = j + directions[k][1];
            if (valid(board, ii, jj)) {
                dfs(board, ii, jj);
            }
        }

    }

    private boolean atEdges(char[][] board, int i, int j) {
        return i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
    }

    private boolean valid(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public static void main(String[] args) {
        SurroundAreas s = new SurroundAreas();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        s.solve(board);
        Utils.print(board);
    }
}
