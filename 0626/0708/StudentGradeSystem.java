
    
public class StudentGradeSystem {

    // 根據成績給等級
    public static char getGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else {
            return 'D';
        }
    }

    public static void main(String[] args) {
        // 1. 建立學生分數陣列
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        // 宣告變數
        int total = 0;
        double average;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        int countA = 0, countB = 0, countC = 0, countD = 0;
        int countAboveAverage = 0;

        // 計算總分與最高最低分
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            total += score;

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }

            // 統計等級人數
            char grade = getGrade(score);
            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }
        }

        // 計算平均
        average = total / (double) scores.length;

        // 計算高於平均的人數
        for (int score : scores) {
            if (score > average) {
                countAboveAverage++;
            }
        }

        // 3. 輸出成績報告
        System.out.println("===== 成績報告 =====");
        System.out.printf("總分: %d\n", total);
        System.out.printf("平均分數: %.2f\n", average);
        System.out.println("最高分: " + max + "（學生編號: " + maxIndex + "）");
        System.out.println("最低分: " + min + "（學生編號: " + minIndex + "）");
        System.out.printf("高於平均的學生比例: %.2f%%\n", (countAboveAverage * 100.0 / scores.length));

        // 統計摘要
        System.out.println("各等級人數:");
        System.out.println("A: " + countA + " 人");
        System.out.println("B: " + countB + " 人");
        System.out.println("C: " + countC + " 人");
        System.out.println("D: " + countD + " 人");

        // 分隔線
        System.out.println("----------------------------");

        // 詳細列表
        System.out.println("學生編號 | 分數 | 等級");
        System.out.println("----------------------------");
        for (int i = 0; i < scores.length; i++) {
            char grade = getGrade(scores[i]);
            System.out.printf("    %2d    |  %3d |   %c\n", i, scores[i], grade);
        }
        System.out.println("============================");
    }
}

