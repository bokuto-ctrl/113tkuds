public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][]a={
            {1,2},
            {3,4}
        };
        int[][]b= {
            {5,6},
            {7,8}
        };
    int[][]c=new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                int sum=0;
                String step="";
                String sumParts="";

                for(int k=0;k<2;k++){
                    int partial=a[i][k]*b[k][j];
                    sum+=partial;

                    step+=a[i][k]*b[k][j];
                    sumParts+=partial;

                    if(k<1){
                        step+="+";
                        sumParts+="+";
                    }
                }
            c[i][j]=sum;
            System.out.println("計算位子c["+i+"]["+j+"]:"+step+"="+sum);
            }
        }
        System.out.println("\n結果矩陣:");
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.println(c[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
