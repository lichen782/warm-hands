package cn.lich.itv.one50;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false
 *
 * @author lich
 * @date 2024/2/9
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firsts = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firsts[i] = matrix[i][0];
        }
        int row = search(firsts, target); //[0, matrix.length]
        if (row < matrix.length && matrix[row][0] == target) {
            return true;
        }
        if (row != 0) {
            row--;
        }
        int col = search(matrix[row], target);
        return col < matrix[0].length && matrix[row][col] == target;
    }

    private int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low++;
            } else if (nums[mid] > target) {
                high--;
            } else {
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchMatrix s = new SearchMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = s.searchMatrix(matrix, 16);
        System.out.println(b);
    }

}
