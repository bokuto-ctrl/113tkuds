import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] incomes = new int[n];
        int[] taxes = new int[n];
        int totalTax = 0;
        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
            taxes[i] = computeTax(incomes[i]);
            totalTax += taxes[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Tax: $" + taxes[i]);
        }
        double average = (double) totalTax / n;
        System.out.printf("Average: $%.2f\n", average);
    }
    public static int computeTax(int income) {
        int tax = 0;
        int[] limits = {540000, 1210000, 2420000, 4530000}; // 上限
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        int[] bases = {0, 27000, 142800, 376600, 829600}; // 累計速算扣除額

        if (income <= limits[0]) {
            tax = (int)(income * rates[0]);
        } else if (income <= limits[1]) {
            tax = (int)(income * rates[1] - bases[1]);
        } else if (income <= limits[2]) {
            tax = (int)(income * rates[2] - bases[2]);
        } else if (income <= limits[3]) {
            tax = (int)(income * rates[3] - bases[3]);
        } else {
            tax = (int)(income * rates[4] - bases[4]);
        }
        return tax;
    }
}
/*
 * 時間複雜度：O(n)
 * 說明：輸入 n 筆收入，對每筆計算稅額為常數時間，總共花費線性時間。
 */


