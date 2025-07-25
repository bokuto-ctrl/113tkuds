// BSTRangeQuery.java

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTRangeQuery {

    // 回傳範圍內的節點值（遞增排序）
    public static void rangeQuery(TreeNode root, int min, int max, ArrayList<Integer> result) {
        if (root == null) return;

        // 左子樹有可能有落在範圍內的值
        if (root.val > min) {
            rangeQuery(root.left, min, max, result);
        }

        // 當前節點值在範圍內
        if (root.val >= min && root.val <= max) {
            result.add(root.val);
        }

        // 右子樹有可能有落在範圍內的值
        if (root.val < max) {
            rangeQuery(root.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        /*
               20
              /  \
            10    30
           / \    / \
          5  15  25  35
        */

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        ArrayList<Integer> result = new ArrayList<>();
        rangeQuery(root, 12, 27, result);
        System.out.println("範圍 [12, 27] 的節點值: " + result); // 預期輸出: [15, 20, 25]
    }
}
