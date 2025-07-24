public class FactorialExampleinput {
    public static int factorial(int n){
        // 停止條件：0! = 1, 1! = 1
        if(n<=1){
            System.out.print("1");
            return 1;
        }
        System.out.print(n+"*");
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.print("3!=");
        int result1=factorial(3);
        System.out.println("="+result1);
        System.out.print("5!=");
        int result2=factorial(5);
        System.out.println("="+result2);
        System.out.print("6!=");
        int result3=factorial(6);
        System.out.print("="+result3);
    }
}
