import java.util.*;
public class FibonacciDP {
    static int count;
    static int dp[];
    public static int fib(int num){
        count++;
        if(dp[num]!=-1){
            return dp[num];
        }
        if(num==1){
            return 1;
        }
        if(num==0){
            return 0;
        }
        int result=fib(num-1)+fib(num-2);
        dp[num]=result;
        return result;
    }
    public static void main(String[] args){
        int num=1000;
        dp=new int[num+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(num));
        System.out.println("count "+count);
    }
}
