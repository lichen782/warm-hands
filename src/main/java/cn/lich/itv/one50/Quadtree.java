package cn.lich.itv.one50;

import cn.lich.itv.utils.Utils;
import cn.lich.itv.utils.quadtree.Node;


/**
 * @author lich
 * @date 2024/2/7
 */
public class Quadtree {

    class Range {
        int rowStart;
        int rowEnd;

        int colStart;
        int colEnd;

        Range(int rowStart, int rowEnd, int colStart, int colEnd) {
            this.rowStart = rowStart;
            this.rowEnd = rowEnd;
            this.colStart = colStart;
            this.colEnd = colEnd;
        }

        public String toString() {
            return "[" + rowStart + "~" + rowEnd + "," + colStart + "~" + colEnd + "]";
        }
    }

    public Node construct(int[][] grid) {
        return construct(grid, new Range(0, grid.length, 0, grid.length));
    }

    private Node construct(int[][] grid, Range r) {
        System.out.println(r);
        if (r.rowEnd - r.rowStart <= 1 || r.colEnd - r.colStart <= 1) {
            return new Node(grid[r.rowStart][r.colStart] == 1, true);
        }

        boolean allLeaf = true;
        int rowMid = r.rowStart + (r.rowEnd - r.rowStart) / 2;
        int colMid = r.colStart + (r.colEnd - r.colStart) / 2;
        Range topLeft = new Range(r.rowStart, rowMid, r.colStart, colMid);
        Node topLeftNode = construct(grid, topLeft);
        allLeaf &= topLeftNode.isLeaf;

        Range topRight = new Range(r.rowStart, rowMid, colMid, r.colEnd);
        Node topRightNode = construct(grid, topRight);
        allLeaf &= topRightNode.isLeaf;

        Range bottomLeft = new Range(rowMid, r.rowEnd, r.colStart, colMid);
        Node bottomLeftNode = construct(grid, bottomLeft);
        allLeaf &= bottomLeftNode.isLeaf;

        Range bottomRight = new Range(rowMid, r.rowEnd, colMid, r.colEnd);
        Node bottomRightNode = construct(grid, bottomRight);
        allLeaf &= bottomRightNode.isLeaf;

        // should merge
        if (allLeaf) {
            if (topLeftNode.val == topRightNode.val && topRightNode.val == bottomRightNode.val && bottomRightNode.val == bottomLeftNode.val) {
                return new Node(topLeftNode.val, true);
            }
        }
        Node root = new Node(true, false, topLeftNode, topRightNode, bottomLeftNode, bottomRightNode);
        return root;
    }

    public static void main(String[] args) {
        Quadtree q = new Quadtree();
        int[][] grid = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {1, 0, 1, 1}};
        Node root = q.construct(grid);
        Utils.print(root);
    }
}
