public class loopb {
     public static void main(String[] args){
        int x=0;
        int i=1;
        int count=0;//每一個迴圈都是0
        while (++i<=100) {//++i先把i變成2 再檢查
            x=x+1;
            count++;//每跑一次記一次
        }
        System.out.println(count);//99
    }
}

