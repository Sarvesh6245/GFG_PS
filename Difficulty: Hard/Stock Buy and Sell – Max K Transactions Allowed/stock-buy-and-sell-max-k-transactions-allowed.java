//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int A[]) {
        if (K == 0 || N < 2) {
            return 0;
        }
        
        int[][] dp = new int[K + 1][N];
        
        for (int i = 1; i <= K; i++) {
            int maxDiff = -A[0];
            
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i][j-1], A[j] + maxDiff);
                
                maxDiff = Math.max(maxDiff, dp[i-1][j] - A[j]);
            }
        }
        
        return dp[K][N-1];
    }
}