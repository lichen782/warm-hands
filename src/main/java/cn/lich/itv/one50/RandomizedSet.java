package cn.lich.itv.one50;

import java.util.*;

/**
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * @author lich
 * @date 2024/1/1
 */
public class RandomizedSet {

    private HashMap<Integer, Integer> map; // 存储值到索引的映射
    private ArrayList<Integer> list; // 存储所有值
    private Random rand; // 随机数生成器

    /** 初始化 RandomizedSet 对象 */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * 当元素 val 不存在时，向集合中插入该项，并返回 true ；
     * 否则，返回 false 。
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * 当元素 val 存在时，从集合中移除该项，并返回 true ；
     * 否则，返回 false 。
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int indexToRemove = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(indexToRemove, lastElement); // 将最后一个元素移动到要移除的元素的位置
        map.put(lastElement, indexToRemove); // 更新最后一个元素的索引
        list.remove(list.size() - 1); // 移除最后一个元素
        map.remove(val); // 从映射中移除要删除的元素
        return true;
    }

    /** 随机返回现有集合中的一项 */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
