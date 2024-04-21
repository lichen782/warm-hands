package cn.lich.itv.one50;


/**
 * @author lich
 * @date 2024/1/9
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Integer.max(Integer.min(height[i], height[j]) * (j - i), maxArea);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;

    }

    public static void main(String[] args) {
        MaxArea m = new MaxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int max = m.maxArea(height);
        System.out.println(max);
    }
}
