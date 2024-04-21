package cn.lich.itv.one50;

import java.util.*;

/**
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * <p>
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * <p>
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 * @author lich
 * @date 2024/1/30
 */
public class MinMutation {

    private static final int GENE_LENGTH = 8;

    class Node {
        String val;
        List<Node> next;

        Node(String val) {
            this.val = val;
            this.next = new ArrayList<>();
        }
    }

    private Map<String, Node> nodeMap = new HashMap<>();

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        buildGraph(startGene, bank);
        if (!nodeMap.containsKey(endGene)) {
            return -1;
        }
        return bfs(startGene, endGene);
    }

    private int bfs(String startGene, String endGene) {
        LinkedList<Node> queue = new LinkedList<>();
        Node st = nodeMap.get(startGene);
        queue.add(st);
        Map<String, Integer> visited = new HashMap<>();
        visited.put(startGene, 0);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int step = visited.get(n.val) + 1;
            for (Node nxt: n.next) {
                if (nxt.val.equals(endGene)) {
                    return step;
                }
                if (visited.containsKey(nxt.val)) {
                    continue;
                }
                visited.put(nxt.val, step);
                queue.add(nxt);
            }
        }
        return -1;
    }

    private void buildGraph(String startGene, String[] bank) {
        nodeMap.clear();
        for (int i = 0; i < bank.length; i++) {
            nodeMap.put(bank[i], new Node(bank[i]));
        }
        nodeMap.put(startGene, new Node(startGene));
        for (String s1 : nodeMap.keySet()) {
            for (String s2 : nodeMap.keySet()) {
                if (!s1.equals(s2) && link(s1, s2)) {
                    nodeMap.get(s1).next.add(nodeMap.get(s2));
                }
            }
        }
    }

    private boolean link(String start, String end) {
        int diff = 0;
        for (int i = 0; i < GENE_LENGTH; i++) {
            diff += (start.charAt(i) == end.charAt(i) ? 0 : 1);
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        MinMutation m = new MinMutation();
        String[][][] testcases = {
                {{"AACCGGTT", "AACCGGTA"}, {"AACCGGTA"}},
                {{"AACCGGTT", "AAACGGTA"}, {"AACCGGTA","AACCGCTA","AAACGGTA"}},
                {{"AAAAACCC", "AACCCCCC"}, {"AAAACCCC","AAACCCCC","AACCCCCC"}},
        };
        for (String[][] tc: testcases) {
            System.out.println(m.minMutation(tc[0][0], tc[0][1], tc[1]));
        }
    }
}
