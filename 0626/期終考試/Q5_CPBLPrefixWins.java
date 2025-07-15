import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[]result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=sc.nextInt();
        }
        int k=sc.nextInt();

        int[]ps=new int[n+1];
        ps[0]=0;
        for(int i=1;i<=n;i++){
            ps[i]=ps[i-1]+result[i-1];
        }
        System.out.println("PrefixSum:");
        for(int i=1;i<=k;i++){
            System.out.print(" "+ps[i]);
    }
        System.out.println();
     
    }
}
