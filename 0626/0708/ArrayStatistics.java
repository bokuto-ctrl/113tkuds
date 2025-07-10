public class ArrayStatistics {
    public static void main(String[] args) {
        // 1. 建立陣列
        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        double average;
        int max = data[0], min = data[0];
        int maxIndex = 0, minIndex = 0;
        int countAboveAvg = 0;
        int evenCount = 0, oddCount = 0;

        // 2. 計算總和
        for (int value : data) {
            sum += value;
        }

        // 計算平均值
        average = sum / (double) data.length;

        // 計算最大值、最小值及其索引
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }
            if (data[i] < min) {
                min = data[i];
                minIndex = i;
            }
        }

        // 計算大於平均值的數量，以及奇偶數個數
        for (int value : data) {
            if (value > average) {
                countAboveAvg++;
            }
            if (value % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // 3. 輸出統計結果（表格格式）
        System.out.println("===== 陣列統計分析 =====");
        System.out.println("總和\t\t: " + sum);
        System.out.printf("平均值\t\t: %.2f\n", average);
        System.out.println("最大值\t\t: " + max + "（索引 " + maxIndex + "）");
        System.out.println("最小值\t\t: " + min + "（索引 " + minIndex + "）");
        System.out.println("大於平均的數量\t: " + countAboveAvg);
        System.out.println("偶數個數\t: " + evenCount);
        System.out.println("奇數個數\t: " + oddCount);
        System.out.println("==========================");
    }
}

