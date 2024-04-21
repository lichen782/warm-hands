package cn.lich.itv.one50;

import java.util.*;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 *
 * @author lich
 * @date 2024/1/28
 */
public class CalcEquation {

    class Node {
        String val;
        Map<Node, Double> reachable;
    }

    private Map<String, Node> nodeMap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.nodeMap.clear();
        buildGraphOfNext(equations, values);

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            if (!nodeMap.containsKey(start) || !nodeMap.containsKey(end)) {
                result[i] = -1;
                continue;
            }
            double length = bfs(nodeMap.get(start), nodeMap.get(end));
            result[i] = length;
        }

        return result;
    }

    private double bfs(Node start, Node target) {
        LinkedList<Node> q = new LinkedList<>();

        q.addAll(start.reachable.keySet());

        Set<Node> visited = new HashSet<>();
        visited.add(start);

        while (!q.isEmpty()) {
            Node n = q.poll();
            double length = start.reachable.get(n);
            for (Node next : n.reachable.keySet()) {
                if (visited.contains(next)) {
                    continue;
                }
                buildPath(start, next, length * n.reachable.get(next));
                visited.add(next);
                q.add(next);
            }
        }

        if (start.reachable.containsKey(target)) {
            return start.reachable.get(target);
        }
        return -1;
    }

    private Map<String, Node> buildGraphOfNext(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> path = equations.get(i);
            Node startNode = getOrInit(path.get(0));
            Node endNode = getOrInit(path.get(1));
            buildPath(startNode, endNode, values[i]);
        }
        return nodeMap;
    }

    private Node getOrInit(String key) {
        if (!nodeMap.containsKey(key)) {
            Node n = new Node();
            n.val = key;
            n.reachable = new HashMap<>();
            nodeMap.put(key, n);
            n.reachable.put(n, 1d);
        }
        return nodeMap.get(key);
    }

    private void buildPath(Node startNode, Node endNode, double value) {
        startNode.reachable.put(endNode, value);
        endNode.reachable.put(startNode, (double) 1 / value);
    }

    public static List<List<String>> buildListFromArray(String[][] equations) {
        List<List<String>> l = new ArrayList<>();
        for (String[] eq : equations) {
            List<String> eql = new ArrayList<>();
            eql.add(eq[0]);
            eql.add(eq[1]);
            l.add(eql);
        }
        return l;
    }

    public static void main(String[] args) {
        CalcEquation c = new CalcEquation();
        String[][] equations = {
                {"a", "b"},
                //{"b", "c"},
                //{"bc", "cd"},
        };
        double[] values = {0.5};//{1.5, 2.5, 5.0};//{2.0, 3.0};
        String[][] queries = {{"a","b"},{"b","a"},{"a","c"},{"x","y"}};//{{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};//{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        List<List<String>> eqs = buildListFromArray(equations);
        List<List<String>> qrs = buildListFromArray(queries);
        double[] result = c.calcEquation(eqs, values, qrs);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println();
    }
}
