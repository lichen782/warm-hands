package cn.lich.itv.one19;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * <p>
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * <p>
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 * <p>
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *
 * @author lich
 * @date 2024/3/18
 */
public class NumMatrix {


    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (i == 0) {
                sum[i][0] = matrix[i][0];
            } else {
                sum[i][0] = sum[i - 1][0] + matrix[i][0];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum[0][i] = matrix[0][0];
            } else {
                sum[0][i] = sum[0][i - 1] + matrix[0][i];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = sum[row2][col2];
        if (col1 > 0) {
            ans -= sum[row2][col1 - 1];
        }

        if (row1 > 0) {
            ans -= sum[row1 - 1][col2];
        }

        if (col1 > 0 && row1 > 0) {
            ans += sum[row1 - 1][col1 - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix n = new NumMatrix(matrix);

        int[][] cases = {
                {2, 1, 4, 3},
                {1, 1, 2, 2},
                {1, 2, 2, 4}
        };

        for (int i = 0; i < cases.length; i++) {
            System.out.println(n.sumRegion(cases[i][0], cases[i][1], cases[i][2], cases[i][3]));
        }
    }
}
