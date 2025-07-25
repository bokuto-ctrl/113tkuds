// BSTValidation.java

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTValidation {

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 用遞迴與區間限制來檢查是否合法 BST
    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // 合法 BST 範例
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.right.left = new TreeNode(12);
        root1.right.right = new TreeNode(20);

        System.out.println("範例一為合法 BST? " + isValidBST(root1)); // true

        // 非法 BST 範例
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(8); // 錯誤：8 < 10，但卻在右子樹

        System.out.println("範例二為合法 BST? " + isValidBST(root2)); // false
    }
}

