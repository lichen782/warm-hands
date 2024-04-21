package cn.lich.itv.one19;

import cn.lich.itv.utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 *
 * 提示：
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * @author lich
 * @date 2024/3/31
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int[] ans = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pre = stack.pop();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] temp = {30,60,90};
        int[] ans = d.dailyTemperatures(temp);
        Utils.print(ans);
    }
}
