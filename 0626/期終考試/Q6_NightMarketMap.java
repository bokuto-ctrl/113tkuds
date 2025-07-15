import java.util.Scanner;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        final int SIZE=10;
        char[][]map=new char[SIZE][SIZE];

        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                map[i][j]='#';
            }
        }
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            int r=sc.nextInt();
            int c=sc.nextInt();

            if(r>=0 && r < SIZE && c>=0 && c<SIZE){
                map[r][c]='*';
            }
        }
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                System.out.println(map[i][j]);
            }
            System.out.println();
        }
    }
}
