package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * . Q . .
 * . . . Q
 * Q . . .
 * . . Q .
 * <p>
 * . . Q .
 * Q . . .
 * . . . Q
 * . Q . .
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 *
 * @author lich
 * @date 2024/2/4
 */
public class QueenII {

    private int total = 0;

    private int n;

    private boolean[] columns;

    private boolean[] left;

    private boolean[] right;

    public int totalNQueens(int n) {
        init(n);

        dfs(0);

        return total;
    }

    private void dfs(int row) {
        if (row == n) {
            total++;
            return;
        }

        List<Integer> cols = availableCol(row);
        for (Integer candidateCol : cols) {
            columns[candidateCol] = true;
            left[n + row - candidateCol] = true;
            right[candidateCol + row] = true;

            dfs(row + 1);

            columns[candidateCol] = false;
            left[n + row - candidateCol] = false;
            right[candidateCol + row] = false;
        }
    }

    private List<Integer> availableCol(int row) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (columns[i]) {
                continue;
            }

            if (left[n + row - i]) {
                continue;
            }
            if (right[i + row]) {
                continue;
            }

            res.add(i);
        }
        return res;
    }

    private void init(int n) {
        this.n = n;
        this.columns = new boolean[n];
        this.left = new boolean[2 * n];
        this.right = new boolean[2 * n - 1];
        this.total = 0;
    }

    public static void main(String[] args) {
        QueenII q = new QueenII();
        q.totalNQueens(4);
        for (int i = 1; i <= 9; i++) {
            System.out.println(i + ": " + q.totalNQueens(i));
        }
    }
}
