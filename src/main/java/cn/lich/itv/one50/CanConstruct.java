package cn.lich.itv.one50;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @author lich
 * @date 2024/1/14
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int offset = magazine.charAt(i) - 'a';
            counter[offset]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int offset = ransomNote.charAt(i) - 'a';
            if (counter[offset] == 0) {
                return false;
            }
            counter[offset]--;
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct c = new CanConstruct();
        System.out.println(c.canConstruct("aa", "ab"));
    }
}
