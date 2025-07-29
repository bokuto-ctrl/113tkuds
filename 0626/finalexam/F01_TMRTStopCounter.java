import java.util.Scanner;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int ids1 = -1, ids2 = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) ids1 = i;
            if (stops[i].equals(end)) ids2 = i;
        }

        if (ids1 == -1 || ids2 == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(ids1 - ids2) + 1);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：一次走訪陣列 stops[] 長度為 n，尋找 start 與 end 的索引，
 * 其餘為 O(1)，整體時間為 O(n)。
 */
