package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2023/12/29
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int m = nums[0];
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == m) {
                c++;
            } else {
                c--;
                if (c == 0) {
                    m = nums[i];
                    c = 1;
                }
            }
        }
        return m;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int majority = m.majorityElement(nums);
        System.out.println("majority: " + majority);
    }
}
