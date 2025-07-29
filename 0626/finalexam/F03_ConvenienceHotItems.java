import java.util.Scanner;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine(); 
        String[] names = new String[n];
        int[] qtys = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            qtys[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            String tempName = names[i];
            int tempQty = qtys[i];
            int j = i - 1;
            while (j >= 0 && qtys[j] < tempQty) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            names[j + 1] = tempName;
            qtys[j + 1] = tempQty;
        }
        for (int i = 0; i < Math.min(n, 10); i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
}
/*
 * Time Complexity: O(n^2)
 * 說明：使用插入排序進行排序，最壞情況下每次插入都需比較到開頭，因此時間複雜度為 O(n^2)。
 * 輸出部分最多輸出 10 筆資料，屬於 O(1)，所以整體仍為 O(n^2)。
 */
