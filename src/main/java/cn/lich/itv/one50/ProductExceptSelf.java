package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/3
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] x = new int[nums.length];
        x[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // x[i] = nums[0] * nums[1]... * nums[i - 1]
            x[i] = x[i - 1] * nums[i - 1];
        }

        int sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0 ; i--) {
            x[i] = x[i] * sum;
            sum *= nums[i];
        }

        return x;
    }

    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        int[] nums = {-1,1,0,-3,3};
        int[] r = p.productExceptSelf(nums);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + ",");
        }
    }
}
