package cn.lich.itv.one50;

/**
 * https://leetcode.cn/problems/summary-ranges/
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author lich
 * @date 2023/8/26
 */
public class SumRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> rlt = new ArrayList<>();

        for (int st = 0; st < nums.length; ) {
            int ed = st + 1;
            while (ed < nums.length) {
                if (nums[ed] == nums[ed - 1] + 1) {
                    ed++;
                } else {
                    break;
                }
            }
            rlt.add(st == ed - 1 ?
                            String.valueOf(nums[st]) : String.format("%s->%s", nums[st], nums[ed - 1]));
            st = ed;
        }

        return rlt;
    }

    public static void main(String[] args) {
        SumRange sr = new SumRange();
        List<String> l = sr.summaryRanges(new int[]{});
        l.forEach(s -> System.out.println(s));
    }
}
