

//Minimum coins required to reach the target


import java.util.*;
public class Mincoin {
    public static void main(String[] args){
        Scanner get=new Scanner(System.in);
        int num=get.nextInt();
        int arr[]=new int[num];
        for(int i=0;i<num;i++){
            arr[i]=get.nextInt();
        }
        int target=get.nextInt();
        int dp[][]=new int [num][target+1];
        for(int i=0;i<num;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=target;i++){
            if(i%arr[0]==0){
                dp[0][i]=i/arr[0];
            }else{
                dp[0][i]=10000;
            }
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=target;j++){
                if(j<arr[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-arr[i]]);
                }
            }
        }
        
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=target;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.print(dp[num-1][target]==10000?"-1":dp[num-1][target]);
   }
}

