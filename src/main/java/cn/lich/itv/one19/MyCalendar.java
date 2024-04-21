package cn.lich.itv.one19;

import java.util.*;

/**
 * 请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 *
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 *
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 *
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 *
 *
 * 示例:
 *
 * 输入:
 * ["MyCalendar","book","book","book"]
 * [[],[10,20],[15,25],[20,30]]
 * 输出: [null,true,false,true]
 * 解释:
 * MyCalendar myCalendar = new MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了
 * MyCalendar.book(20, 30); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20
 *
 * @author lich
 * @date 2024/4/11
 */
public class MyCalendar {

    class Book {

        int start;

        int end;

        public String toString() {
            return "[" + start + ", " + end + ")";
        }
    }

    private TreeMap<Integer, Book> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (treeMap.containsKey(start)) {
            return false;
        }
        Integer upper = treeMap.ceilingKey(start);

        if (upper != null) {
            Book next = treeMap.get(upper);
            if (end > next.start) {
                return false;
            }
        }

        Integer lower = treeMap.floorKey(start);

        if (lower != null) {
            Book before = treeMap.get(lower);
            if (before.end > start) {
                return false;
            }
        }

        Book b = new Book();
        b.start = start;
        b.end = end;

        treeMap.put(start, b);

        return true;
    }

    public void print() {
        for (Integer s: treeMap.keySet()) {
            System.out.println(treeMap.get(s));
        }
    }

    public static void main(String[] args) {
        MyCalendar m = new MyCalendar();
        System.out.println(m.book(10,20));
        System.out.println(m.book(15,25));
        System.out.println(m.book(20,30));

        m.print();
    }
}
