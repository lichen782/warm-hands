package cn.lich.itv.one50;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @author lich
 * @date 2024/2/10
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == nums.length || nums[index] != target) {
            return new int[]{-1, -1};
        }

        int pre = binarySearch(nums, target - 0.1);
        int post = binarySearch(nums, target + 0.1);

        return new int[]{pre, post - 1};
    }

    private int binarySearch(int[] nums, double target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        int[] nums = {5,7,7,8,8,10};
        int[] pos = s.searchRange(nums, 1);
        System.out.println("[" + pos[0] + "," + pos[1] + "]");
    }
}
