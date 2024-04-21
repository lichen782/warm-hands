package cn.lich.itv.utils.doubly;

import cn.lich.itv.utils.Utils;

/**
 * @author lich
 * @date 2024/3/24
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public static void main(String[] args) {
        Integer[] nums = {
                1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12
        };
        Node head = Utils.init(nums);
        Utils.print(head);
    }
}
