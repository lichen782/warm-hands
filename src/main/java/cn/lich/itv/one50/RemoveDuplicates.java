package cn.lich.itv.one50;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 *
 * i = 0, j = 1 -> 1 [0,1,1,1,1,2,2,3,3,4]
 * i = 1, j = 2 -> 5 [0,1,2,1,1,2,2,3,3,4]
 *
 * @author lich
 * @date 2023/12/28
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i  = 0;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j = j + 1;
            }
        }
        return i+1;
    }


    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] nums = {0,1,2,3};
        int s = r.removeDuplicates(nums);
        System.out.println("size: " + s);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

}
