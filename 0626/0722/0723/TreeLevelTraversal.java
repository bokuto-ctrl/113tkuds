// TreeLevelTraversal.java

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeLevelTraversal {

    // 功能 1：一般層序，每層一個 List
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    // 功能 2：之字形層序遍歷
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    // 功能 3：只印出每一層的最後一個節點
    public static List<Integer> rightmostEachLevel(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode last = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                last = node;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(last.val);
        }
        return result;
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

        System.out.println("每層儲存為 List：");
        List<List<Integer>> level = levelOrder(root);
        System.out.println(level); // [[1], [2, 3], [4, 5, 6]]

        System.out.println("之字形層序遍歷：");
        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        System.out.println(zigzag); // [[1], [3, 2], [4, 5, 6]]

        System.out.println("每層最後一節點：");
        List<Integer> last = rightmostEachLevel(root);
        System.out.println(last); // [1, 3, 6]
    }
}

