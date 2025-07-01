
import java.util.Scanner;



public class searchnumberary {
    public static void main(String[] args) {
        int[]n={1,2,3,4,5,6,7,8,9,10};
        Scanner sc=new Scanner(System.in);
        System.out.print("請輸入要查的數字");
        int x=sc.nextInt();

        int left=0;
        int right=n.length-1;
        boolean found=false;

        while (left<=right) {
            int mid=(left+right)/2;
            System.out.println("比對中:x="+x+",中間元素="+n[mid]);
            
            if(n[mid]==x){
                found=true;
                break;
            }else if (n[mid]<x){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(found){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
