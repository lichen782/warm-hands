package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/14
 */
public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }

        int[] maps = new int[128];
        int[] mapped = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (maps[s.charAt(i)] != 0 && maps[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
            if (mapped[t.charAt(i)] != 0 && mapped[t.charAt(i)] != s.charAt(i)) {
                return false;
            }

            maps[s.charAt(i)] = t.charAt(i);
            mapped[t.charAt(i)] = s.charAt(i);
        }

        return true;
    }

    public static void main(String[] args) {
        Isomorphic i = new Isomorphic();
        System.out.println(i.isIsomorphic("badc", "baba"));
    }
}
