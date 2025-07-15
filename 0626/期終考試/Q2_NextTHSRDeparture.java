import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[]timeTable=new int[n];

        for(int i=0;i<n;i++){
            String timeString=sc.next();
            timeTable[i]=toMinutes(timeString);
        }
        String query=sc.next();
        int queryTime=toMinutes(query);

        int resultIdx=-1;
        int left=0,rigth=n-1;

        while (left<=rigth) {
            int mid=(left+rigth)/2;
            if(timeTable[mid]>queryTime){
                resultIdx=mid;
                rigth=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(resultIdx==-1){
            System.out.println("No train");
        }else{
            System.out.println(toHHMM(timeTable[resultIdx]));
        }
        sc.close();
    }
    private static int toMinutes(String time){
        String[]parts=time.split(":");
        int hh=Integer.parseInt(parts[0]);
        int mm=Integer.parseInt(parts[1]);
        return hh*60+mm;
    }
    private static String toHHMM(int minutes){
        int hh=minutes/60;
        int mm=minutes%60;
        return String.format("%02d:%02d", hh,mm);
    }
}
