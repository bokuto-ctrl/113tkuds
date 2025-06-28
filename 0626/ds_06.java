
import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        int[]n=new int[10];
        Random random=new Random();
        System.out.println("隨機產生得陣列元素");
        for (int i = 0; i < n.length; i++) {
            n[i]=random.nextInt(100);
            System.out.println(n[i]+"");
        }
        int max=n[9];
        for(int num:n){
            if(num>max){
                max=num;
            }
        }
        System.out.println("\n陣列中的最大值為:"+max);
    }
}
