package cn.lich.itv.one50;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 *
 * @author lich
 * @date 2024/1/15
 */
public class TwoSumUnSorted {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], new ArrayList<>());
            }
            indexMap.get(nums[i]).add(i);
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int cur = nums[i] + nums[j];
            if (cur > target) {
                j--;
            } else if (cur < target) {
                i++;
            } else {
                result[0] = indexMap.get(nums[i]).get(0);
                result[1] = indexMap.get(nums[j]).get(nums[i] != nums[j] ? 0 : 1);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumUnSorted t = new TwoSumUnSorted();
        int[] nums = {3,3};
        int[] result = t.twoSum(nums, 6);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
