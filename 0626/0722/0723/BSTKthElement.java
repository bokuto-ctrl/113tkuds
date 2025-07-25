

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTKthElement {

    // 全域變數：用來追蹤第 k 小的遞增順序與結果
    private static int count = 0;
    private static int result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    // 中序遍歷：遞增順序
    private static void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return;

        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        /*
               20
              /  \
            10    30
           / \    /
          5  15  25
        */

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);

        for (int k = 1; k <= 6; k++) {
            System.out.println("第 " + k + " 小的元素: " + kthSmallest(root, k));
        }
        // 預期輸出：
        // 第 1 小的元素: 5
        // 第 2 小的元素: 10
        // 第 3 小的元素: 15
        // 第 4 小的元素: 20
        // 第 5 小的元素: 25
        // 第 6 小的元素: 30
    }
}
