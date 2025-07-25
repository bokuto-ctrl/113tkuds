// TreeMirror.java

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeMirror {

    // 判斷是否為對稱樹（鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    // 將一棵樹轉成鏡像（就地修改）
    public static void mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    // 判斷兩棵樹是否互為鏡像
    public static boolean areMirrors(TreeNode a, TreeNode b) {
        return isMirror(a, b);
    }

    // 前序遍歷（輔助觀察）
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
               1
              / \
             2   2
            / \ / \
           3  4 4  3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("是否為對稱樹: " + isSymmetric(root)); // true

        System.out.print("原樹前序遍歷: ");
        preorder(root);
        System.out.println();

        mirror(root);

        System.out.print("鏡像樹前序遍歷: ");
        preorder(root);
        System.out.println();

        // 測試互為鏡像
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(3);
        b.right = new TreeNode(2);

        System.out.println("a 與 b 是否互為鏡像: " + areMirrors(a, b)); // true
    }
}
