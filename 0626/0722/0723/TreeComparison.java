// TreeComparison.java

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeComparison {

    // 1. 判斷兩個樹是否完全相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 2. 判斷 t 是否是 s 的子樹
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 3. 找出兩個樹的最大公共子樹（最大共同子樹）
    // 回傳最大公共子樹的根節點（如果有多個最大，回傳任一）
    public static TreeNode largestCommonSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return null;

        // 若根節點相同且子樹相同，則整棵樹為公共子樹
        if (isSameTree(root1, root2)) return root1;

        // 否則分別在 root1 左右子樹尋找最大公共子樹
        TreeNode left = largestCommonSubtree(root1.left, root2);
        TreeNode right = largestCommonSubtree(root1.right, root2);

        // 取較大（依節點數）的子樹
        int leftSize = subtreeSize(left);
        int rightSize = subtreeSize(right);

        return leftSize >= rightSize ? left : right;
    }

    // 計算子樹節點數
    public static int subtreeSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + subtreeSize(root.left) + subtreeSize(root.right);
    }

    // 輔助函數：前序遍歷輸出
    public static void preorderPrint(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public static void main(String[] args) {
        /*
          樹 s:
               3
              / \
             4   5
            / \
           1   2

          樹 t:
             4
            / \
           1   2
        */

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println("s 和 t 是否完全相同？ " + isSameTree(s, t)); // false
        System.out.println("t 是否為 s 的子樹？ " + isSubtree(s, t)); // true

        TreeNode common = largestCommonSubtree(s, t);
        System.out.print("最大公共子樹前序遍歷: ");
        preorderPrint(common);  // 預期輸出: 4 1 2

    }
}
