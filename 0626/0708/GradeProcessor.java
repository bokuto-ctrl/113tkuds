public class GradeProcessor {
    public static void main(String[] args) {
        // 1. 建立包含 8 位學生成績的陣列
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        int total = 0;
        double average;
        int maxScore = scores[0], minScore = scores[0];
        int maxIndex = 0, minIndex = 0;
        int aboveAverageCount = 0;

        // 2. 計算總分
        for (int score : scores) {
            total += score;
        }

        // 計算平均分數，保留兩位小數
        average = total / (double) scores.length;

        // 3. 找出最高分與最低分及其索引
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
            if (scores[i] < minScore) {
                minScore = scores[i];
                minIndex = i;
            }
        }

        // 4. 計算成績超過平均的人數
        for (int score : scores) {
            if (score > average) {
                aboveAverageCount++;
            }
        }

        // 5. 輸出成績資料
        System.out.println("成績處理系統");
        System.out.println("----------");
        System.out.println("總分: " + total);
        System.out.printf("平均分數: %.2f\n", average);
        System.out.println("最高分: " + maxScore + " (索引 " + maxIndex + ")");
        System.out.println("最低分: " + minScore + " (索引 " + minIndex + ")");
        System.out.println("成績高於平均的人數: " + aboveAverageCount);
        System.out.println("----------");
        System.out.println("學生編號: 成績");

        for (int i = 0; i < scores.length; i++) {
            System.out.println("學生 " + i + ": " + scores[i]);
        }
    }
}
 
    

