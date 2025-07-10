public class ArraySearcher {
    // 2. 搜尋指定的數值，回傳其索引（若找不到則回傳 -1）
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // 找到目標，回傳索引
            }
        }
        return -1; // 沒找到
    }

    // 4. 計算目標值在陣列中出現的次數
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 1. 建立陣列
        int[] numbers = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        // 5. 測試搜尋數字 67 和 100
        int target1 = 67;
        int target2 = 100;

        // 搜尋 target1
        int index1 = findElement(numbers, target1);
        System.out.println("搜尋數字 " + target1 + " 的索引位置: " + index1);
        System.out.println("出現次數: " + countOccurrences(numbers, target1));

        // 搜尋 target2
        int index2 = findElement(numbers, target2);
        System.out.println("搜尋數字 " + target2 + " 的索引位置: " + index2);
        System.out.println("出現次數: " + countOccurrences(numbers, target2));
    }
}


