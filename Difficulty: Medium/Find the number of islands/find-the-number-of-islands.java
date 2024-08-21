//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    
    public void dfs(int row,int col,char[][] grid,int[][] visited){
        
        visited[row][col]=1;
        
        int drow[]= {0,0,-1,1,-1,-1,1,1};
        int dcol[]= {1,-1,0,0,1,-1,1,-1};
        
        for(int i=0; i<=7; i++){
            for(int j=0; j<=7; j++){
                
                int crow=drow[i]+row;
                int ccol=dcol[i]+col;
                
                if(crow>=0 && crow<grid.length && ccol>=0 && ccol<grid[0].length && visited[crow][ccol]==0 && grid[crow][ccol]=='1'){
                    dfs(crow,ccol,grid,visited);
                }
                
            }
        }
      }
    public int numIslands(char[][] grid) {
        
        int[][] visited=new int[grid.length][grid[0].length];
        int cnt=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        
        return cnt;
    }
}