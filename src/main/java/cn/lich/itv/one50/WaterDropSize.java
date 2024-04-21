package cn.lich.itv.one50;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author lich
 * @date 2024/2/29
 */
public class WaterDropSize {

    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);

        int dropSize = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[i - 1]) {
                int pre = stack.peek();
                while (!stack.isEmpty()) {
                    int left = stack.peek();
                    if (height[left] <= height[i]) {
                        dropSize += (height[left] - height[pre]) * (i - left - 1);
                        stack.pop();
                    } else {
                        dropSize += (height[i] - height[pre]) * (i - left - 1);
                        break;
                    }
                    pre = left;
                }
            }
            stack.push(i);
        }

        return dropSize;
    }

    public int trap2(int[] height) {
        int leftMax = height[0];
        int left = 0;

        int rightMax = height[height.length - 1];
        int right = height.length - 1;

        int dropSize = 0;

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax < rightMax) {
                dropSize += leftMax - height[left];
                left++;
            } else {
                dropSize += rightMax - height[right];
                right--;
            }
        }
        return dropSize;
    }

    public static void main(String[] args) {
        WaterDropSize w = new WaterDropSize();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(w.trap2(height));
    }
}
