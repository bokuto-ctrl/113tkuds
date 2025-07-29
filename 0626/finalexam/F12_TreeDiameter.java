import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxDiameter = 0; // 全域變數追蹤最大直徑

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 層序輸入建樹（-1 表 null）
        String[] arr = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = buildTree(arr);
        maxDiameter = 0;
        height(root);
        System.out.println("Diameter: " + maxDiameter);
    }

    static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode curr = q.poll();
            if (!arr[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // 後序遞迴求高度並更新直徑
    static int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // 直徑是左高 + 右高，因為是邊數
        int diameterThroughNode = leftHeight + rightHeight;
        if (diameterThroughNode > maxDiameter) {
            maxDiameter = diameterThroughNode;
        }

        // 回傳高度 = max(左右高) + 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
