// BSTConversion.java

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTConversion {

    static TreeNode prev = null;  // 用於雙向鏈結串列轉換時追蹤前一節點
    static TreeNode head = null;  // 雙向鏈結串列頭節點

    // 1. 將 BST 轉換成排序的雙向鏈結串列（中序遍歷）
    public static void bstToDoublyList(TreeNode root) {
        prev = null;
        head = null;
        convert(root);
    }

    private static void convert(TreeNode root) {
        if (root == null) return;
        convert(root.left);

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        convert(root.right);
    }

    public static void printDoublyList(TreeNode head) {
        TreeNode curr = head;
        System.out.print("雙向鏈結串列: ");
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    // 2. 將排序陣列轉換為平衡 BST
    public static TreeNode sortedArrayToBST(int[] arr) {
        return buildBST(arr, 0, arr.length - 1);
    }

    private static TreeNode buildBST(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBST(arr, left, mid - 1);
        root.right = buildBST(arr, mid + 1, right);
        return root;
    }

    // 3. 將 BST 的每個節點值改為所有大於等於該節點值的節點值總和
    static int sum = 0;

    public static void bstToGreaterSumTree(TreeNode root) {
        sum = 0;
        reverseInorder(root);
    }

    private static void reverseInorder(TreeNode node) {
        if (node == null) return;
        reverseInorder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorder(node.left);
    }

    // 中序遍歷列印樹節點
    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        // 範例 BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // 1. BST 轉雙向鏈結串列
        bstToDoublyList(root);
        printDoublyList(head);  // 預期: 1 2 3 4 5 

        // 2. 排序陣列轉平衡 BST
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstRoot = sortedArrayToBST(arr);
        System.out.print("排序陣列轉 BST 的中序遍歷: ");
        inorderPrint(bstRoot);
        System.out.println();

        // 3. BST 轉換為大於等於節點值總和樹
        bstToGreaterSumTree(bstRoot);
        System.out.print("BST 轉換為大於等於節點值總和樹中序遍歷: ");
        inorderPrint(bstRoot);
        System.out.println();
    }
}


