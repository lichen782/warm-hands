package cn.lich.itv.one50;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 *
 *            i       j
 * [0,0,1,1,2,3,2,3,3,4]
 *
 * @author lich
 * @date 2023/12/28
 */
public class RemoveDupII {

    public int removeDuplicates(int[] nums) {
        int i  = 0;
        int j = i + 1;
        int w = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
                w++;
            } else {
                // i: the num
                // j: the next num
                // w: n of same elements
                int offset = Math.min(w, 2);
                for (int k = 0; k < offset; k++) {
                    nums[i + k] = nums[i];
                }
                nums[i + offset] = nums[j];
                i += offset;
                w = 1;
                j = j + 1;
            }
        }
        for (int k = 0; k < Math.min(w, 2); k++) {
            nums[i + k] = nums[i];
        }
        return i+Math.min(w, 2);
    }

    public static void main(String[] args) {
        RemoveDupII r = new RemoveDupII();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int s = r.removeDuplicates(nums);
        System.out.println("size: " + s);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

}
