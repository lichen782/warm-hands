package cn.lich.itv.one19;

import java.util.*;

/**
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "10203040"
 * 输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
 *
 * @author lich
 * @date 2024/5/5
 */
public class RestoreIpAddresses {

    private Map<Integer, LinkedHashSet<Integer>> posMap;

    private Deque<String> path;

    private String ipStr;

    private List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        posMap = new HashMap<>();
        path = new ArrayDeque<>();
        ipStr = s;
        ans = new ArrayList<>();

        initPosMap(s);

        dfs(0);

        return ans;
    }

    private void dfs(int from) {
        if (path.size() > 4) {
            return;
        }

        if (from == ipStr.length() && path.size() == 4) {
            ans.add(String.join(".", path));
            return;
        }

        if (!posMap.containsKey(from)) {
            return;
        }

        for (Integer end: posMap.get(from)) {
            path.add(ipStr.substring(from, end));
            dfs(end);
            path.removeLast();
        }
    }

    private void initPosMap(String s) {
        for (int i = 0; i < s.length(); i++) {
            LinkedHashSet<Integer> endPos = new LinkedHashSet<>();
            for (int j = 1; j <= 3; j++) {
                if (i + j > s.length()) {
                    break;
                }
                String digital = s.substring(i, i + j);

                if (digital.startsWith("0") && !digital.equals("0")) {
                    continue;
                }

                int d = Integer.valueOf(digital);

                if (d >= 0 && d <= 255) {
                    endPos.add(i + j);
                }
            }
            if (!endPos.isEmpty()) {
                posMap.put(i, endPos);
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        String s = "0000";
        List<String> ans = r.restoreIpAddresses(s);
        for (String ip: ans) {
            System.out.println(ip);
        }
    }

}
