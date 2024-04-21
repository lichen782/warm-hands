package cn.lich.itv.one19;

import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：
 *
 * insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
 * getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
 *
 * @author lich
 * @date 2024/3/29
 */
public class RandomizedSet {

    // value -> index
    private Map<Integer, Integer> pos = new HashMap<>();

    private List<Integer> array = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (pos.containsKey(val)) {
            return false;
        }

        array.add(val);
        pos.put(val, array.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!pos.containsKey(val)) {
            return false;
        }

        int index = pos.get(val);
        int nval = array.get(index);
        assert nval == val;

        int lastOne = array.get(array.size() - 1);
        array.set(index, lastOne);
        pos.put(lastOne, index);
        array.remove(array.size() - 1);
        pos.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(array.size());
        return array.get(randomNumber);
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.insert(3));
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(4));
        System.out.println(rs.remove(1));

        System.out.println(rs.insert(4));

        System.out.println(rs.getRandom());
        System.out.println(rs.getRandom());
    }
}
