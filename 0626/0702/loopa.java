public class loopa {
    public static void main(String[] args){
        int x=0;
        int count=0;//每一個迴圈都是0
        for(int i=1;i<=100;i+=2){//迴圈
            x=x+1;
            count++;//每跑一次記一次
        }
        System.out.println(count);
    }
}
