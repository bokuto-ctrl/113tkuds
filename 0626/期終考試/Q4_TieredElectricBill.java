import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        int[] result = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < low || arr[i] > high) {
                result[count] = arr[i];
                count++;
            }
        }

        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.print(result[i]);
            if (i < count - 1) System.out.print(" ");
        }
        System.out.println(); // 換行
      
    }
}
