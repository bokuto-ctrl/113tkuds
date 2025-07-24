// 樹節點類別
class TreeNode {
    int val;           // 節點儲存的整數值
    TreeNode left;     // 左子節點
    TreeNode right;    // 右子節點

    // 建構子：建立含指定值的節點
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class inOrder {

    // 中序走訪：左 -> 根 -> 右（遞迴）
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);              // 先走訪左子樹
            System.out.print(root.val + " "); // 再印出目前節點
            inOrder(root.right);             // 最後走訪右子樹
        }
    }

    public static void main(String[] args) {
        /*
         建立下列測試用的二元樹：
         
                 1
                / \
               2   3
              / \
             4   5
         
         中序走訪結果應為：4 2 5 1 3
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("中序走訪結果：");
        inOrder(root); // 呼叫中序走訪
        System.out.println(); // 換行
    }
}


