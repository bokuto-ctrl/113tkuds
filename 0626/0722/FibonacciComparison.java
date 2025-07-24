import java.util.Scanner;

class FibonacciComparison {

    // 標準遞迴版本
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    // 記憶化版本
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入 n：");
        int n = scanner.nextInt();

        // 呼叫 slow 版本
        long startSlow = System.nanoTime();
        int resultSlow = fibonacciSlow(n);
        long endSlow = System.nanoTime();

        System.out.println("fibonacciSlow(" + n + ") = " + resultSlow);
        System.out.println("耗時（slow）： " + (endSlow - startSlow) + " ns");

        // 呼叫 fast 版本
        long startFast = System.nanoTime();
        int[] memo = new int[n + 1]; // 預設為 0
        int resultFast = fibonacciFast(n, memo);
        long endFast = System.nanoTime();

        System.out.println("fibonacciFast(" + n + ") = " + resultFast);
        System.out.println("耗時（fast）： " + (endFast - startFast) + " ns");

        scanner.close();
    }
}
