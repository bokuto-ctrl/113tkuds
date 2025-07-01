

public class array_sum_trace {
    public static void main(String[] args) {
     int[]arr={1,3,5};
     int total=0;
     for(int num:arr){
        System.out.println("加總過程:total="+total+"+"+num+"="+(total+num));
        total+=num;
    }
     System.out.println("總合為:"+total);
    }
}
