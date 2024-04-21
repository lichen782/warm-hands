package cn.lich.itv.one19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * 示例 4：
 *
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 * @author lich
 * @date 2024/3/31
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> resistStack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                resistStack.push(i);
            } else { // < 0, evil comes
                while (!resistStack.isEmpty()) {
                    int resistIndex = resistStack.peek();
                    if(asteroids[resistIndex] > -asteroids[i]) {
                        //resist win, evil terminated!
                        asteroids[i] = 0;
                        break;
                    } else if (asteroids[resistIndex] < -asteroids[i]){
                        //can't resist negative, man down, let next man standing front
                        asteroids[resistIndex] = 0;
                        resistStack.pop();
                    } else {
                        // die with the evil
                        asteroids[resistIndex] = 0;
                        asteroids[i] = 0;
                        resistStack.pop();
                        break;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] != 0) {
                ans.add(asteroids[i]);
            }
        }
        int[] rt = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            rt[i] = ans.get(i);
        }
        return rt;
    }

    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        int[] asteroids = {-2,-1,1,2};
        int[] result = a.asteroidCollision(asteroids);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}
