package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/14
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            counter[pos]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int pos = t.charAt(i) - 'a';
            if (counter[pos] == 0) {
                return false;
            }
            counter[pos]--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Anagram a = new Anagram();
        System.out.println(a.isAnagram("rat", "car"));
    }

}
