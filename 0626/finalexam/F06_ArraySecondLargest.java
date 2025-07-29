import java.util.Scanner;

public class F06_ArraySecondLargest {
    static class Pair {
        int max;
        int secondMax;
        Pair(int max, int secondMax) {
            this.max = max;
            this.secondMax = secondMax;
        }
    }
    public static Pair findSecondLargest(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }
        int mid = (left + right) / 2;
        Pair leftPair = findSecondLargest(arr, left, mid);
        Pair rightPair = findSecondLargest(arr, mid + 1, right);
        int max, secondMax;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            secondMax = Math.max(leftPair.secondMax, rightPair.max);
        } else if (rightPair.max > leftPair.max) {
            max = rightPair.max;
            secondMax = Math.max(rightPair.secondMax, leftPair.max);
        } else {
            max = leftPair.max;
            secondMax = Math.max(leftPair.secondMax, rightPair.secondMax);
        }
        return new Pair(max, secondMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 輸入陣列長度
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 輸入陣列內容
        }
        Pair result = findSecondLargest(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.secondMax);
        sc.close();
    }
}
/*
 * 時間複雜度：O(n)
 * 說明：遞迴每層處理 O(1) 合併動作，總共處理所有元素一次，所以是線性 O(n)
 * 遞迴深度最多 log n 層。
 */
