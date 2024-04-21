package cn.lich.itv.one50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lich
 * @date 2024/2/17
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n: nums) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }
        for (Integer n: map.keySet()) {
            if (map.get(n) == 1) {
                return n;
            }
        }
        throw new RuntimeException("not exist");
    }
}
