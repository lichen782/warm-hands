package cn.lich.itv.one50;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * @author lich
 * @date 2024/2/9
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

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
        SearchInsert s = new SearchInsert();
        int[] nums = {1};

        System.out.println(s.searchInsert(nums, 4));
    }
}