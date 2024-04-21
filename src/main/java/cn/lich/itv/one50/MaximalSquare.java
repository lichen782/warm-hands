package cn.lich.itv.one50;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * @author lich
 * @date 2024/2/25
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSquareSize = 0;

        int[][] recSize = new int[m][n];
        int[] zerosCol = new int[n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                recSize[0][i] = 1;
                maxSquareSize = 1;
                zerosCol[i] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                recSize[i][0] = 1;
                maxSquareSize = 1;
            }
        }

        zerosCol[0] = matrix[0][0] == '0' ? 0 : 1;
        for (int i = 1; i < m; i++) {
            int consecutiveZero = matrix[i][0] == '0' ? 0 : 1;
            zerosCol[0] = matrix[i][0] == '0' ? 0 : zerosCol[0] + 1;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    consecutiveZero = 0;
                    zerosCol[j] = 0;
                    continue;
                }
                consecutiveZero++;
                zerosCol[j]++;
                if (recSize[i - 1][j - 1] > 0) {
                    recSize[i][j] = Math.min(consecutiveZero, zerosCol[j]);
                    recSize[i][j] = Math.min(recSize[i][j], recSize[i - 1][j - 1] + 1);
                } else {
                    recSize[i][j] = 1;
                }
                maxSquareSize = Math.max(recSize[i][j] * recSize[i][j], maxSquareSize);
            }
        }

        return maxSquareSize;
    }


    public static void main(String[] args) {
        MaximalSquare m = new MaximalSquare();
        char[][] matrix = {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(m.maximalSquare(matrix));
    }
}
