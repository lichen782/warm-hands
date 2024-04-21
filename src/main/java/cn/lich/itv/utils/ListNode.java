package cn.lich.itv.utils;

/**
 * @author lich
 * @date 2024/1/18
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;

    }

    public void setNext(ListNode next) {
        this.next = next;
    }


    public String toString() {
        return String.valueOf(val);
    }

}