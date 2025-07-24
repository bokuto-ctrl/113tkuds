import java.util.Scanner;

    // 計算數字各位數字總和（遞迴）
    public static int digitSum(int n) {
        if (n < 10) {
            return n; // 基本情況：個位數，直接回傳
        } else {
            return n % 10 + digitSum(n / 10); // 拆解：個位數 + 其餘部分的總和
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 使用者輸入一個正整數
        System.out.print("請輸入一個正整數：");
        int n = scanner.nextInt();

        // 檢查是否為正整數
        if (n <= 0) {
            System.out.println("請輸入正整數！");
        } else {
            int sum = digitSum(n);
            System.out.println("各位數字總和為：" + sum);
        }

        scanner.close();
    }


