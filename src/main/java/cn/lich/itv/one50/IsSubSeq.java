package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/7
 */
public class IsSubSeq {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int ti = 0, si = 0;
        while (ti < t.length() && si < s.length()) {
            while (ti < t.length() && t.charAt(ti) != s.charAt(si)) {
                ti++;
            }
            //ti == si or ti consumed
            if (ti == t.length()) {
                return false;
            }
            si++;
            ti++;
        }

        return si==s.length();
    }

    public static void main(String[] args) {
        IsSubSeq is = new IsSubSeq();
        System.out.println(is.isSubsequence("abc", "ahbgdc"));
        System.out.println(is.isSubsequence("axc", "abc"));
    }
}
