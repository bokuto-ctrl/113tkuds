// BSTBalance.java

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTBalance {

    // 用於記錄最不平衡節點與其平衡因子
    static TreeNode mostUnbalancedNode = null;
    static int maxImbalance = 0;

    // 1. 檢查是否平衡
    public static boolean isBalanced(TreeNode root) {
        maxImbalance = 0;
        mostUnbalancedNode = null;
        return checkHeight(root) != -1;
    }

    // 遞迴回傳節點高度，若不平衡則回傳 -1
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        int balanceFactor = leftHeight - rightHeight;

        if (Math.abs(balanceFactor) > 1) {
            if (Math.abs(balanceFactor) > maxImbalance) {
                maxImbalance = Math.abs(balanceFactor);
                mostUnbalancedNode = node;
            }
            return -1;  // 不平衡，終止向上回傳
        }

        // 紀錄最大不平衡點（即使平衡，找最接近不平衡）
        if (Math.abs(balanceFactor) > maxImbalance) {
            maxImbalance = Math.abs(balanceFactor);
            mostUnbalancedNode = node;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 2. 計算指定節點的平衡因子（左高 - 右高）
    public static int balanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 3. 找出最不平衡的節點（在 isBalanced 呼叫後結果才有效）
    public static TreeNode getMostUnbalancedNode() {
        return mostUnbalancedNode;
    }

    public static void main(String[] args) {
        /*
             10
            /  \
           5    15
          /    /  \
         2    12   20
        /
       1
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        System.out.println("是否為平衡樹? " + isBalanced(root)); // false

        TreeNode unbalanced = getMostUnbalancedNode();
        if (unbalanced != null) {
            System.out.println("最不平衡節點值: " + unbalanced.val);
            System.out.println("該節點平衡因子: " + balanceFactor(unbalanced));
        }

        // 測試平衡因子計算
        System.out.println("節點 10 的平衡因子: " + balanceFactor(root));
        System.out.println("節點 5 的平衡因子: " + balanceFactor(root.left));
        System.out.println("節點 15 的平衡因子: " + balanceFactor(root.right));
    }
}


