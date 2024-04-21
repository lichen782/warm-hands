package cn.lich.itv.one50;

/**
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 * @author lich
 * @date 2024/1/14
 */
public class LifeGame {

    // from 0 -> 1
    private static final int FROM_0_TO_1 = 2;

    // from 1 -> 0
    private static final int FROM_1_TO_0 = 3;

    private static final int[][] direction = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {1, 1},
            {-1, -1},
            {1, -1},
            {-1, 1},
    };

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = countLiveOnes(board, i, j);
                if (lives < 2 && board[i][j] == 1) {
                    board[i][j] = FROM_1_TO_0;
                } else if ((lives == 3 || lives == 2) && board[i][j] == 1) {
                    board[i][j] = 1;
                } else if (lives > 3 && board[i][j] == 1) {
                    board[i][j] = FROM_1_TO_0;
                } else if (lives == 3 && board[i][j] == 0) {
                    board[i][j] = FROM_0_TO_1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == FROM_1_TO_0) {
                    board[i][j] = 0;
                } else if (board[i][j] == FROM_0_TO_1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLiveOnes(int[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        int lives = 0;
        for (int k = 0; k < direction.length; k++) {
            int ii = i + direction[k][0];
            int jj = j + direction[k][1];
            if (isValid(ii, jj, n, m) && (board[ii][jj] == 1 || board[ii][jj] == FROM_1_TO_0)) {
                lives++;
            }
        }
        return lives;
    }


    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public static void main(String[] args) {
        LifeGame l = new LifeGame();
        int[][] boards = {{1,1},{1,0}}; //{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        l.gameOfLife(boards);
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                System.out.print(boards[i][j] + ",");
            }
            System.out.println();
        }
    }
}
