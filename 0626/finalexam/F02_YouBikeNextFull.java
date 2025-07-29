import java.util.Scanner;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = toMinutes(sc.nextLine()); // 轉換為分鐘
        }
        int query = toMinutes(sc.nextLine());
        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.printf("%02d:%02d\n", times[ans] / 60, times[ans] % 60);
        }
    }
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
/*
 * Time Complexity: O(log n)
 * 說明：
 * 已知時間表已排序，使用 binary search 搜尋第一個大於查詢時間的時刻，
 * 因此主體搜尋部分為 O(log n)。
 * 輸入與轉換各為 O(n)，但搜尋是主問題關注的部分，因此查詢時間複雜度為 O(log n)。
 */

