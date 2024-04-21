package cn.lich.itv.one50;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @author lich
 * @date 2024/1/14
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int circle = 0;

        while (circle < n / 2) {
           int upper = circle, left = circle;
           int right = n - circle - 1, lower = n - circle - 1;

           for (int i = left; i <= right - 1; i++) {
               int offset = i - left;
               // -> matrix[upper][left + offset]
               // -> matrix[upper + offset][right]
               // -> matrix[lower][right - offset]
               // -> matrix[lower - offset][left]
               // -> matrix[upper][left + offset]

               int cur = matrix[upper][left + offset];
               int next = matrix[upper + offset][right];

               matrix[upper + offset][right] = cur;

               cur = next;
               next = matrix[lower][right - offset];

               matrix[lower][right - offset] = cur;

               cur = next;
               next = matrix[lower - offset][left];

               matrix[lower - offset][left] = cur;

               cur = next;
               next = matrix[upper][left + offset];

               matrix[upper][left + offset] = cur;

           }
           circle++;
        }
    }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        r.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
}
