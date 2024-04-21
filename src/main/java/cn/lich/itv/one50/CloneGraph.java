package cn.lich.itv.one50;


import cn.lich.itv.utils.Utils;
import cn.lich.itv.utils.graph.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lich
 * @date 2024/1/27
 */
public class CloneGraph {

    private Map<Integer, Node> newNodeMap;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        newNodeMap = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node node) {

        if (newNodeMap.containsKey(node.val)) {
            return node;
        }
        
        Node newNode = cloneOf(node);

        for (Node neighbor: node.neighbors) {
            dfs(neighbor);
            newNode.neighbors.add(cloneOf(neighbor));
        }

        return newNode;
    }

    private Node cloneOf(Node node) {
        if (!newNodeMap.containsKey(node.val)) {
            newNodeMap.put(node.val, new Node(node.val));
        }
        return newNodeMap.get(node.val);
    }

    public static void main(String[] args) {
        int[][] graphs = {};
        Node node = Utils.initAdjGraph(graphs);
        Utils.print(node);

        System.out.println("after clone:");

        CloneGraph c = new CloneGraph();
        Node cloned = c.cloneGraph(node);

        Utils.print(cloned);

    }
}
