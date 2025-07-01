
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
            System.out.println("比對中:x="+x+",中間元素="+n[mid]);
            if(num==x){
                found=true;
                break;
            }
        }
        //輸入結果
        if(found){

        }
    }
}
