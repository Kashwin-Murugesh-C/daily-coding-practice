
class coin2{
    public static void main(String[] args){
        int coins[]={1,3,5};
        int amount=9;
        int dp[][]=new int [coins.length][amount+1];
        
        //filling the 0th column
        
        for(int i=0;i<coins.length;i++){
            dp[i][0]=0;
        }
        
        //filling the 0th row 
        
        for(int i=1;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }
            else{
                dp[0][i]=50;
            }
        }
        
        //for other rows
        
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j], (1+dp[i][j-coins[i]]));
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
        
        //checking answer exists or not
            
        if(dp[coins.length-1][amount]>amount){
            System.out.print("Answer Doesn't exists");
        }else{
            System.out.print("Minimum coins requires: "+ dp[coins.length-1][amount]);
        }
    }
}