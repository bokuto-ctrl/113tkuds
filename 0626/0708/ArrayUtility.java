
    import java.util.Arrays;

public class ArrayUtility {

    // 列印陣列內容，格式為 [元素1, 元素2, ...]
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // 原地反轉陣列（不建立新陣列）
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // 交換元素
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // 建立陣列的副本（deep copy）
    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    // 找出陣列中第二大的數字
    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        // 1. 建立陣列
        int[] original = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.println("原始陣列:");
        printArray(original);

        // 2. 測試反轉
        reverseArray(original);
        System.out.println("反轉後的陣列:");
        printArray(original);

        // 3. 測試副本
        int[] copied = copyArray(original);
        System.out.println("複製的陣列:");
        printArray(copied);

        // 4. 測試找第二大數
        int secondLargest = findSecondLargest(original);
        System.out.println("陣列中的第二大數值: " + secondLargest);
    }
}


