import java.util.*;

public class F10_BSTRangeSum {
    // 樹節點定義
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 層序輸入（-1 表 null）
        String[] arr = sc.nextLine().split(" ");
        int L = sc.nextInt();
        int R = sc.nextInt();
        sc.close();

        TreeNode root = buildTree(arr);
        int sum = rangeSum(root, L, R);
        System.out.println("RangeSum: " + sum);
    }

    // 建立 BST（假設輸入是層序且符合 BST）
    static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode curr = queue.poll();
            // 左子
            if (!arr[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(curr.left);
            }
            i++;
            // 右子
            if (i < arr.length && !arr[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    // 區間總和（中序 + 剪枝）
    static int rangeSum(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if (root.val < L) {
            return rangeSum(root.right, L, R); // 左邊全部都小，剪掉
        } else if (root.val > R) {
            return rangeSum(root.left, L, R); // 右邊全部都大，剪掉
        } else {
            // 落在區間內，左右都要加
            return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
        }
    }
}

