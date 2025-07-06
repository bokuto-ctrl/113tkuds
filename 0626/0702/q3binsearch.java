import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 陣列大小
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int key = sc.nextInt(); // 要找的數
        int ops = 0;
        int left = 0, right = n - 1, index = -1;

        while (left <= right) {
            ops++;
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println(index);
        System.out.println(ops);
    }
}
