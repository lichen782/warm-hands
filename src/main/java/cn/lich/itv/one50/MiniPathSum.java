package cn.lich.itv.one50;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author lich
 * @date 2024/2/24
 */
public class MiniPathSum {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(
                        dp[i - 1][j],
                        dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MiniPathSum m = new MiniPathSum();
        int[][] grid ={
            {
                1, 3, 1
            },{
                1, 5, 1
            },{
                4, 2, 1
            }
        } ;
        System.out.println(m.minPathSum(grid));
    }
}
