package cn.lich.itv.one19;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * @author lich
 * @date 2024/3/12
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int n = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    n++;
                }
            }
            if (n % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumberII s = new SingleNumberII();
        int[] nums = {2,2,3,2};
        System.out.println(s.singleNumber(nums));
    }
}
