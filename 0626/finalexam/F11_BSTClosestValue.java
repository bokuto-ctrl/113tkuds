import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 層序輸入建樹（-1 表空）
        String[] arr = sc.nextLine().split(" ");
        int T = sc.nextInt();
        sc.close();

        TreeNode root = buildTree(arr);
        int ans = closestValue(root, T);
        System.out.println("ClosestValue: " + ans);
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

    static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode curr = root;

        while (curr != null) {
            int currDiff = Math.abs(curr.val - target);
            int closestDiff = Math.abs(closest - target);
            if (currDiff < closestDiff || (currDiff == closestDiff && curr.val < closest)) {
                closest = curr.val;
            }

            if (target < curr.val) {
                curr = curr.left;
            } else if (target > curr.val) {
                curr = curr.right;
            } else {
                break; // exact match
            }
        }

        return closest;
    }
}
