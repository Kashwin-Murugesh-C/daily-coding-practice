public class Subset_sum{
    public static void main(String[] args){
        int [] set={2,3,5,7,10};
        int sum=14;
        int[][] dp=new int [set.length][sum+1];
        
        // fill 1st column
        
        for(int i=0;i<set.length;i++){
            dp[i][0]=1;
        }
        
        //for filling 1st row
        
        for(int i=1;i<=sum;i++){
            if(i==set[0]) dp[0][i]=1;
            else dp[0][i]=0;
        }
        
        //for rest of the columns
        
        for(int i=1;i<set.length;i++){
            for(int j=1;j<=sum;j++){
                if(j<set[i]){
                    dp[i][j]=dp[i-1][j];
                }else if(dp[i-1][j]==1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j-set[i]];
                }
            }
        }
        
        //for dipslay
        
        for(int i=0;i<set.length;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}