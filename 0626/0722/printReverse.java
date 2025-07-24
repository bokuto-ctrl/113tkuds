// 定義 ListNode 類別（單向鏈結串列節點）
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}



    // 遞迴方式反向列印鏈結串列
    public static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }

        // 遞迴走訪至尾端
        printReverse(head.next);

        // 回來時印出節點（即反向列印）
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        /*
         測試用鏈結串列：
         建立 1 -> 2 -> 3 -> 4 -> 5
         預期反向列印：5 4 3 2 1
        */

        // 建立節點
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 執行反向列印
        System.out.print("反向列印結果：");
        printReverse(head);
        System.out.println(); // 換行
    }

