package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2023/8/27
 */
public class MagicDictionary {

    private String[] dictionary;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        for (String s : dictionary) {
            if (match(s, searchWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }

        char[] leftChars = left.toCharArray();
        char[] rightChars = right.toCharArray();

        int matches = 0;
        for (int i = 0; i < leftChars.length; i++) {
            matches += (leftChars[i] == rightChars[i] ? 1 : 0);
        }

        return matches == leftChars.length - 1;
    }

    public static void main(String[] args) {
        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[] {"hello", "leetcode"});
        String[] searchWords = {"hello", "hhllo", "hell", "leetcoded"};
        for (String searchWord : searchWords) {
            System.out.println(String.format("%s: %s", searchWord, m.search(searchWord)));
        }
    }
}
