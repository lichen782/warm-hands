package cn.lich.itv.one19;

/**
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
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
 * 示例 4:
 *
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 *
 * 输入: nums = [1], target = 0
 * 输出: 0
 * @author lich
 * @date 2024/4/23
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        int[][] testcases = {
                {1,3,5,6}, {5}, {2},
                {1,3,5,6}, {2}, {1},
                {1,3,5,6}, {0}, {0},
                {1},       {0}, {0},
        };
        for (int i = 0; i <= testcases.length - 3; i += 3) {
            int idx = s.searchInsert(testcases[i], testcases[i + 1][0]);
            System.out.println("expected: " + testcases[i + 2][0] + ", actual: " + idx);
            assert idx == testcases[i + 2][0];
        }
    }
}
