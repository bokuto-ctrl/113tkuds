import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[]score=new int[n];

        for(int i=0;i<n;i++){
            score[i]=sc.nextInt();
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(score[i]==5){
                count++;
            }
        }
        if(count==0){
            System.out.println("None");
        }else{
            int[]result=new int[count];
            int idx=0;

            for(int i=0;i<n;i++){
                if(score[i]==5){
                    result[idx++]=i;
                }
            }
            for(int i=0;i<count;i++){
                System.out.println(result[i]);
                if(i<count-1)System.out.print("");
            }
            System.out.println();
        }
    }
}
