import java.util.*;
public class FractionalKnapsack{
    public static void main(String[] args){
        int values[] ={2,3,4,1};
        int weights[]={3,4,5,6};
        int capacity=8;
        int [][]dp=new int[values.length+1][capacity+1];
        
        //fill first column
        
        for(int i=0;i<=values.length;i++){
            dp[i][0]=0;
        }
        
        //fill first row
        
        for(int i=1;i<=capacity;i++){
            dp[0][i]=0;
        }
        
        //display content
        
        for(int i=1;i<=values.length;i++){
            for(int j=1;j<=capacity;j++){
                if(j<weights[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max((values[i-1]+dp[i-1][j-weights[i-1]]),(dp[i-1][j]));
                }
            }
        }
        
        
        for(int i=0;i<=values.length;i++){
            for(int j=0;j<=capacity;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
        
    }
}