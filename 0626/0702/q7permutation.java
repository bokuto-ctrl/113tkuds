import java.util.Scanner;

public class q7permutation {
    static int ops = 0;

    public static void permute(int[] arr, int start) {
        if (start == arr.length) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            ops++;
        } else {
            for (int i = start; i < arr.length; i++) {
                swap(arr, start, i);
                permute(arr, start + 1);
                swap(arr, start, i); // 還原
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        permute(arr, 0);
        System.out.println(ops);
    }
}
