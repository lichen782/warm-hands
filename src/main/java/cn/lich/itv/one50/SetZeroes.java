package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/14
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int[] r = new int[7]; // 7 * 32 = 224
        int[] c = new int[7]; // 7 * 32 = 224;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    mark(r, i);
                    mark(c, j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (fetch(r, i)) {
                setZeroForRow(matrix, i);
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (fetch(c, i)) {
                setZeroForCol(matrix, i);
            }
        }
    }

    private void mark(int[] bitmap, int bit) {
        bitmap[bit/32] |= 1<<(bit % 32);
    }

    private boolean fetch(int[] bitmap, int bit) {
        return (bitmap[bit/32] & 1<<(bit % 32)) != 0;
    }

    private void setZeroForRow(int[][] m, int row) {
        for (int i = 0; i < m[0].length; i++) {
            m[row][i] = 0;
        }
    }

    private void setZeroForCol(int[][] m, int col) {
        for (int i = 0; i < m.length; i++) {
            m[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        SetZeroes s = new SetZeroes();
        int[][] matrix =   {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        s.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
}
