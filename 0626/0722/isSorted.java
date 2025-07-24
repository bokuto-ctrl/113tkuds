import java.util.Scanner;

    // 遞迴檢查陣列是否升序
    public static boolean isSorted(int[] arr, int index) {
        // 若長度為 0 或 1 或已檢查到最後一個元素，視為已排序
        if (arr == null || arr.length <= 1 || index >= arr.length - 1) {
            return true;
        }

        // 若某對相鄰元素不符合升序，則回傳 false
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 遞迴檢查下一組元素
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入陣列長度
        System.out.print("請輸入陣列長度：");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // 輸入陣列元素
        System.out.println("請輸入陣列元素（共 " + n + " 個）：");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 檢查陣列是否升序排列
        boolean result = isSorted(arr, 0);

        // 輸出結果
        if (result) {
            System.out.println("陣列為升序排列");
        } else {
            System.out.println("陣列未升序排列");
        }

        scanner.close();
    }

