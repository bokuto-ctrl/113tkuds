public class loopc {
     public static void main(String[] args){
        int x=-100;
        int count=0;//每一個迴圈都是0
        do{//迴圈
            x=x+1;
            count++;//每跑一次記一次
        }while(x++<=100);
        System.out.println(count);
    }
}

