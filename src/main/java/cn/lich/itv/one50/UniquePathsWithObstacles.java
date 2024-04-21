package cn.lich.itv.one50;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * @author lich
 * @date 2024/2/24
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (j > 0 ? dp[i][j - 1] : 0) + (i > 0 ? dp[i - 1][j] : 0);
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePathsWithObstacles u = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {
                {0,0,0},{0,1,0},{0,0,0}
        };
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid));
    }
}
