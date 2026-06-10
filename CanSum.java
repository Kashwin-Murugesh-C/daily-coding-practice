import java.util.*;
public class CanSum{
    public static void main(String[] args){
        Scanner get=new Scanner(System.in);
        int num=get.nextInt();
        get.nextLine();
        String str=get.nextLine();
        str=str.substring(1,str.length()-1);
        String strarr[]=str.split(",");
        int arr[]=new int[strarr.length];
        for(int i=0;i<strarr.length;i++){
            arr[i]=Integer.parseInt(strarr[i]);
        }
        System.out.println("DP Table:");
        
        //constructing dp table
        
        boolean dp[]=new boolean[num+1];
        dp[0]=true;
        for(int i=0;i<=num;i++){
            if(dp[i]){
                for(int j:arr){
                    if(i+j<=num){
                        dp[i+j]=true;
                    }
                }
            }
        }

        //printing

        System.out.print("Index : ");
        for(int i=0;i<=num;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("Value : ");
        for(int i=0;i<=num;i++){
            System.out.print(dp[i]==true?"T ":"F ");
        }
        System.out.println();
        System.out.println();
        System.out.print("Result: "+ dp[dp.length-1]);
    }
}