import java.util.Scanner;

    // 計算費波納契數列的第 n 項（遞迴）
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0; // 第 0 項為 0
        } else if (n == 1) {
            return 1; // 第 1 項為 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // 遞迴公式
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入要查詢的費波納契項數
        System.out.print("請輸入要計算的費波納契項數 n：");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("請輸入非負整數！");
        } else {
            int result = fibonacci(n);
            System.out.println("費波納契數列第 " + n + " 項為：" + result);
        }

        scanner.close();
    }

