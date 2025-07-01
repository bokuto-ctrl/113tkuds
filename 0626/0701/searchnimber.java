
import java.util.Scanner;

public class searchnimber{
    public static void main (String[]args){
        int[]n={1,2,3,4,5};
        Scanner sc=new Scanner(System.in);
        System.out.print("請輸入要查的數字");
        int x=sc.nextInt();
        boolean found=false;
        //線性搜尋
        for(int num:n){
            System.out.println("比對中:x="+x+",中間元素="+n[num]);
            if(num==x){
                found=true;
                break;
            }
        }
        //輸入結果
        if(found){
            System.out.println("找到了！數字 " + x + " 存在於陣列中。");
        } else {
            System.out.println("找不到，數字 " + x + " 不在陣列中。");
        }
    }
}
