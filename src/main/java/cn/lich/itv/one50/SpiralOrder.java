package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @author lich
 * @date 2024/1/13
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length;
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> l = new ArrayList<>();
        int circle = 0;
        while (l.size() < total) {
            int i = circle;
            int j = circle;

            for (; j < m - circle && l.size() < total; j++) {
                l.add(matrix[i][j]);
            }
            i++;
            j--;

            for (; i < n - circle && l.size() < total; i++) {
                l.add(matrix[i][j]);
            }
            i--;
            j--;

            for (; j >= circle && l.size() < total; j--) {
                l.add(matrix[i][j]);
            }
            i--;
            j++;

            for (; i > circle && l.size() < total; i--) {
                l.add(matrix[i][j]);
            }

            circle++;
        }
        return l;
    }

    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        int[][] matrix ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> l = s.spiralOrder(matrix);
        for (Integer i: l) {
            System.out.print(i + ",");
        }
    }
}
