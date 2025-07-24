import java.util.Scanner;
public class gcd {
    public static int gcd(int a,int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("請輸入第一個整數 a：");
        int a = sc.nextInt();

        System.out.print("請輸入第二個整數 b：");
        int b = sc.nextInt();

        // 呼叫 gcd 函式並輸出結果
        int result = gcd(a, b);
        System.out.println("最大公因數為：" + result);
    }
}
