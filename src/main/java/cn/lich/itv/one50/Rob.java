package cn.lich.itv.one50;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author lich
 * @date 2024/2/21
 */
public class Rob {

    public int rob(int[] nums) {
        int si = nums[0];
        int ni = 0;
        for (int i = 1; i < nums.length; i++) {
            int sii = ni + nums[i];
            int nii = Math.max(si, ni);

            si = sii;
            ni = nii;
        }

        return Math.max(si, ni);
    }

    public static void main(String[] args) {
        Rob r = new Rob();
        int[] nums = {2,7,9,3,1};
        System.out.println(r.rob(nums));
    }
}

