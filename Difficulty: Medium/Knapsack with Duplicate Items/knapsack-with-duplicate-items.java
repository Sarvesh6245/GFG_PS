//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int w, int profit[], int wt[])
    {
        int dp[][] = new int[n+1][w+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int maxProfit = solve(profit,wt,w,dp,n-1);
        return maxProfit;
    }
    public static int solve(int profit[],int wt[],int w,int dp[][],int pos){
        
        if(pos<0){
            return 0;
        }
        if(dp[pos][w]!=-1){
            return dp[pos][w];
        }
        if(wt[pos]>w){//exclude : if curr weight is grater than capacity.
            return dp[pos][w]=solve(profit,wt,w,dp,pos-1);
        }else{
            return dp[pos][w]=Math.max(
                solve(profit,wt,w-wt[pos],dp,pos)+profit[pos],//include
                solve(profit,wt,w,dp,pos-1)//exclude
            );
        }
        
    }
}