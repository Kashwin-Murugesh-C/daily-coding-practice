// DP program coin-1 self:

class coin1{
    public static void main(String[] args){
        int coins[]={2,3,5};
        int amount=5;
        int dp[][]=new int [coins.length][amount+1];
        
        //filling the 0th column
        
        for(int i=0;i<coins.length;i++){
            dp[i][0]=1;
        }
        
        //filling the 0th row 
        
        for(int i=1;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=1;
            }
            else{
                dp[0][i]=0;
            }
        }
        
        //for other rows
        
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                }
            }
        }        
        
        //display
        
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}