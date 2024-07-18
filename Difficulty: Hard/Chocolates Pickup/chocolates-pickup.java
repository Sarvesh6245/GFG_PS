//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
       int[][] prev = new int[m][m];
        int[][] curr = new int[m][m];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                prev[i][j] = grid[n-1][i];
                if(i!=j) prev[i][j] += grid[n-1][j];
            }
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j1=0; j1<m; j1++){
                for(int j2=0; j2<m; j2++){
                    curr[j1][j2] = grid[i][j1];
                    if(j1 != j2){
                        curr[j1][j2] += grid[i][j2];
                    }
                    int max = -100001;
                    for(int k=-1; k<2; k++){
                        for(int l=-1; l<2; l++){
                            if(j1+k >= 0 && j1+k < m && j2+l >= 0 && j2+l < m){
                                max = Math.max(max, prev[j1+k][j2+l]);
                            }
                        }
                    }
                    curr[j1][j2] += max;
                }
            }
            for(int x=0; x<m; x++){
                prev[x] = Arrays.copyOf(curr[x],m);
            }
        }
        
        return prev[0][m-1];
    }
}