import java.util.Scanner;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase(); // 忽略大小寫
        int[] freq = new int[26]; // A~Z 共 26 字母

        // 統計字母出現次數（忽略非字母）
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[c - 'a']++;
            }
        }

        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 == 1) oddCount++;
        }

        // 回文允許最多一個字母是奇數次
        if (oddCount <= 1) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }

        sc.close();
    }
}
