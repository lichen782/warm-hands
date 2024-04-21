package cn.lich.itv.one50;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * @author lich
 * @date 2024/2/9
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        return findPeakRange(nums, 0, nums.length - 1);
    }

    private int findPeakRange(int[] nums, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if ((mid == 0 || nums[mid - 1] < nums[mid]) &&
                (mid == nums.length - 1 || nums[mid + 1] < nums[mid])) {
            return mid;
        }
        int index = findPeakRange(nums, mid + 1, high);
        if (index == -1) {
            return findPeakRange(nums, low, mid - 1);
        }
        return index;
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        int[][] nums = {
                {1, 2, 3, 1},
                {1, 2, 1, 3, 5, 6, 4},
                {1},
                {-2147483648}
        };
        for (int[] ns: nums) {
            System.out.println(f.findPeakElement(ns));
        }
    }
}
