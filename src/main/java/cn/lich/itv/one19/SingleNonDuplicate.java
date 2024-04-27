package cn.lich.itv.one19;

import java.util.Arrays;

/**
 *
 * @author lich
 * @date 2024/4/23
 */
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        SingleNonDuplicate s = new SingleNonDuplicate();
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(s.singleNonDuplicate(nums));
    }
}
