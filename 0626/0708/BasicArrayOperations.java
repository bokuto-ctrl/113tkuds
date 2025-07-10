public class BasicArrayOperations {
    public static void main(String[] args) {
        // 1. 宣告並初始化整數陣列
        int[] numbers = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        // 2. 輸出陣列長度
        System.out.println("陣列長度: " + numbers.length);

        // 3. 修改第 3 個位置（索引 2）的值為 99
        numbers[2] = 99;

        // 4. 修改最後一個位置的值為 100
        numbers[numbers.length - 1] = 100;

        // 5. 使用傳統 for 迴圈輸出所有元素
        System.out.println("陣列內容：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("索引 " + i + ": " + numbers[i]);
        }
    }
}
