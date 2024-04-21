package cn.lich.itv.one50;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [3,2,2,3], val = 2
 * 输出：2, nums = [2,2]
 * i = 0, j = 3, [3,2,2,3]
 * i = 1, j = 3, [3,3,2,2]
 * i = 1, j = 2, [3,3,2,2]
 * i = 2, j = 2, [3,3,2,2]
 * @author lich
 * @date 2023/12/27
 */
public class RemoveDup {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while(i < j) {
            if (nums[i] == val) {
                switch2pos(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                break;
            }
        }
        return i;
    }

    private void switch2pos(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    public static void main(String[] args) {
        RemoveDup r = new RemoveDup();
        int[] nums = {0,1,2,2,3,0,4,2};
        int s = r.removeElement(nums, 2);
        System.out.println("size: " + s);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}
