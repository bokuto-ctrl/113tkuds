// TreeReconstruction.java

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeReconstruction {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();  // 儲存中序索引
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd,
                                  int[] inorder, int inStart, int inEnd,
                                  Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inMap.get(rootVal); // root 在中序中的位置
        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                          inorder, inStart, rootIndex - 1, inMap);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                           inorder, rootIndex + 1, inEnd, inMap);

        return root;
    }

    // 輔助函數：後序輸出
    public static void printPostorder(TreeNode root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.print("重建後的後序遍歷：");
        printPostorder(root);  // 預期輸出：9 15 7 20 3
    }
}

