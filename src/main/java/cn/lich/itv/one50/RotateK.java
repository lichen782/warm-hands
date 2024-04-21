package cn.lich.itv.one50;


import cn.lich.itv.utils.Utils;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * @author lich
 * @date 2023/12/29
 */
public class RotateK {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }

    private void reverse(int[] nums, int i, int j) {
        int s = i;
        int e = j - 1;
        while (s < e) {
            int n = nums[s];
            nums[s] = nums[e];
            nums[e] = n;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        RotateK r = new RotateK();
        r.rotate(nums, 2);

        Utils.print(nums);
    }
}
