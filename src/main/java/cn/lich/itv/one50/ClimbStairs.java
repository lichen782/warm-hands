package cn.lich.itv.one50;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author lich
 * @date 2024/2/21
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int pre = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur = cur + pre;
            pre = temp;
        }

        return cur;
    }

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(3));
    }
}
