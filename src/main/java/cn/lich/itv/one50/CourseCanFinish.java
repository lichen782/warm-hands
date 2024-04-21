package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * @author lich
 * @date 2024/1/28
 */
public class CourseCanFinish {

    class Node {
        int i;

        int pre;

        List<Node> next = new ArrayList<>();

        Node(int i) {
            this.i = i;
        }
    }

    private Map<Integer, Node> nodeMap = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);

        List<Node> zeros;

        while(!nodeMap.isEmpty() && !(zeros = getZeroPreCourse()).isEmpty()) {
            for (Node z: zeros) {
                for (Node n: z.next) {
                    n.pre--;
                }
                nodeMap.remove(z.i);
            }
        }
        return nodeMap.isEmpty();
    }

    private List<Node> getZeroPreCourse() {
        return nodeMap.values().stream().filter(n -> n.pre == 0).collect(Collectors.toList());
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        nodeMap.clear();
        for (int i = 0; i < numCourses; i++) {
            nodeMap.put(i, new Node(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Node c = nodeMap.get(prerequisites[i][0]);
            Node pre = nodeMap.get(prerequisites[i][1]);
            c.pre++;
            pre.next.add(c);
        }
    }

    public static void main(String[] args) {
        CourseCanFinish c = new CourseCanFinish();
        int courseNumber = 2;
        int[][] prerequisites = {
                {1, 0},
                {0, 1},
        };
        System.out.println(c.canFinish(courseNumber, prerequisites));
    }
}
