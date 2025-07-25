// TreeDistance.java

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeDistance {

    // 1. 計算兩節點間距離
    public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
        TreeNode lca = lowestCommonAncestor(root, val1, val2);
        if (lca == null) return -1;
        int d1 = distanceFromNode(lca, val1, 0);
        int d2 = distanceFromNode(lca, val2, 0);
        if (d1 == -1 || d2 == -1) return -1;
        return d1 + d2;
    }

    // 找出兩節點的最低公共祖先 (LCA)
    public static TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2) {
        if (root == null) return null;
        if (root.val == val1 || root.val == val2) return root;

        TreeNode left = lowestCommonAncestor(root.left, val1, val2);
        TreeNode right = lowestCommonAncestor(root.right, val1, val2);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // 計算從 root 到 val 節點的距離
    public static int distanceFromNode(TreeNode root, int val, int dist) {
        if (root == null) return -1;
        if (root.val == val) return dist;

        int leftDist = distanceFromNode(root.left, val, dist + 1);
        if (leftDist != -1) return leftDist;

        return distanceFromNode(root.right, val, dist + 1);
    }

    // 2. 找出樹的直徑 (任意兩節點間最大距離)
    static int diameter = 0;

    public static int treeDiameter(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    // 3. 找出距離根節點指定距離的所有節點
    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        nodesAtDistanceKHelper(root, k, res);
        return res;
    }

    private static void nodesAtDistanceKHelper(TreeNode node, int k, List<Integer> res) {
        if (node == null) return;
        if (k == 0) {
            res.add(node.val);
            return;
        }
        nodesAtDistanceKHelper(node.left, k - 1, res);
        nodesAtDistanceKHelper(node.right, k - 1, res);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("節點 4 和 6 的距離: " + distanceBetweenNodes(root, 4, 6)); // 4
        System.out.println("樹的直徑: " + treeDiameter(root)); // 4 (路徑: 4->2->1->3->6)
        System.out.println("距離根節點 2 的節點: " + nodesAtDistanceK(root, 2)); // [4,5,6]
    }
}
