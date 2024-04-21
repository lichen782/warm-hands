package cn.lich.itv.one19;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @author lich
 * @date 2024/3/31
 */
public class LargestRectangleArea {

    class Item {

        int index;

        int mostLeft;

        Item(int index, int mostLeft) {
            this.index = index;
            this.mostLeft = mostLeft;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Item> stack = new ArrayDeque<>();

        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            Item preItem = null;
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek().index] > heights[i])) {
                preItem = stack.pop();
                maxArea = Math.max(maxArea, (i - preItem.mostLeft) * heights[preItem.index]);
            }
            if (i < heights.length) {
                Item item = new Item(i, preItem != null ? preItem.mostLeft : i);
                //System.out.println("item.i=" + item.index + ",item.mostLeft=" + item.mostLeft);
                stack.push(item);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        int[] heights = {999,999,999,999};
        int maxArea = l.largestRectangleArea(heights);
        System.out.println(maxArea);
    }
}
