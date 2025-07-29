import java.util.*;

public class F09_TreeLeftView {
    // 節點類別
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 讀入層序輸入（-1 表 null）
        String[] arr = sc.nextLine().split(" ");
        sc.close();

        // 建立樹
        TreeNode root = buildTree(arr);

        // 印出左視圖
        printLeftView(root);
    }

    // 建立樹（由層序輸入建立）
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

    // 印出每層最左邊的節點值
    static void printLeftView(TreeNode root) {
        if (root == null) {
            System.out.println("LeftView:");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.print("LeftView:");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) System.out.print(" " + node.val); // 每層的第一個
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        System.out.println();
    }
}


