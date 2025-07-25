// TreeStatistics.java

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeStatistics {

    // 計算總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    // 計算最大值
    public static int max(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    // 計算最小值
    public static int min(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(min(root.left), min(root.right)));
    }

    // 計算葉節點數
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 計算深度（高度）
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    // 測試主程式
    public static void main(String[] args) {
        /*
               10
              /  \
             5    15
            / \     \
           3   7     20
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println("總和: " + sum(root));              // 60
        System.out.println("最大值: " + max(root));            // 20
        System.out.println("最小值: " + min(root));            // 3
        System.out.println("葉節點數量: " + countLeaves(root)); // 3
        System.out.println("樹的高度: " + depth(root));         // 3
    }
}
