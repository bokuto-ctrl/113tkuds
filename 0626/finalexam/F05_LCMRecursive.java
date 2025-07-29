import java.util.Scanner;

public class F05_LCMRecursive {
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        else return gcd(a, b - a);
    }
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = lcm(a, b);
        System.out.println("LCM: " + result);
        sc.close();
    }
}
/*
 * 時間複雜度：O(max(a, b))
 * 說明：輾轉相減法每次遞迴將較大數字減少，最壞情況下會遞迴約 max(a, b) 次，因此時間複雜度為線性 O(max(a, b))。
 * LCM 計算則是常數時間。
 */

