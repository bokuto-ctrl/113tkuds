// TreePathProblems.java

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreePathProblems {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null)
            dfs(root, "", result);
        return result;
    }

    private static void dfs(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);  // 是葉節點，加進結果
            return;
        }
        if (node.left != null)
            dfs(node.left, path + node.val + "->", result);
        if (node.right != null)
            dfs(node.right, path + node.val + "->", result);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
               \
                5
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = binaryTreePaths(root);
        System.out.println("所有根到葉的路徑：");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
