
public class fibonacciSimple {
    public static void main(String[] args) {
        int n=0;//要印出前幾項
        int a=0,b=0;

        System.out.print("費氏數列物"+n+"項");
        for(int i=0;i<n;i++){
            System.out.println(a+"");
            int temp=a+b;
            a=b;
            b=temp;
        }
    }
}
