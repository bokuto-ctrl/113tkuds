public class ArrayAccess {
    public static void main(String[] args) {
        int[]score={85,92,77,60,88};
        //請取操作-隨機存取任意元素
        int firstScore=score[0];   //取的第一個元素:85
        int lastScore=score[4];   //取得最後一個元素:88
        int middleScore=score[2];   //取得中間元素:77

        System.out.println("第一個成績:"+firstScore);
        System.out.println("最後一個成績:"+lastScore);
        System.out.println("中間成績:"+middleScore);
        //修改操作-直接更新指定位置的值
        score[0]=90;   //將第一個成績改為90
        score[score.length-1]=95;   //最後一個成績改為95
        //取得陣列的屬性資訊
        int arrayLength=score.length;  //陣列長度5

        System.out.println("\n修改後的陣列");
        for(int i=0;i<arrayLength;i++){
            System.out.printf("索引%d:%d\n",i,score[i]);
        }

    }
}
