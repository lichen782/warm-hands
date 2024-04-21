package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/6
 */
public class IntToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int ms = num / 1000;
        appendNsOf(sb, "M", ms);

        num %= 1000;
        ms = num / 100;

        if (ms == 9) {
            appendNsOf(sb, "CM", 1);
        } else if (ms == 4) {
            appendNsOf(sb, "CD", 1);
        } else {
            appendNsOf(sb, "D", ms >= 5 ? 1 : 0);
            appendNsOf(sb, "C", ms >= 5 ? ms - 5 : ms);
        }

        num %= 100;
        ms = num / 10;

        if (ms == 9) {
            appendNsOf(sb, "XC", 1);
        } else if (ms == 4) {
            appendNsOf(sb, "XL", 1);
        } else {
            appendNsOf(sb, "L", ms >= 5 ? 1 : 0);
            appendNsOf(sb, "X", ms >= 5 ? ms - 5 : ms);
        }

        num %= 10;
        ms = num / 1;

        if (ms == 9) {
            appendNsOf(sb, "IX", 1);
        } else if (ms == 4) {
            appendNsOf(sb, "IV", 1);
        } else {
            appendNsOf(sb, "V", ms >= 5 ? 1 : 0);
            appendNsOf(sb, "I", ms >= 5 ? ms - 5 : ms);
        }

        return sb.toString();
    }

    private StringBuilder appendNsOf(StringBuilder sb, String r, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(r);
        }
        return sb;
    }

    public static void main(String[] args) {
        IntToRoman i = new IntToRoman();
        int[] nums = {3, 4, 9, 58, 1994};
        for (int n : nums) {
            System.out.println(n + ": " + i.intToRoman(n));
        }
    }
}
