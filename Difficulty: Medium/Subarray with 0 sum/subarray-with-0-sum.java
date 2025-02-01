//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            t--;

            System.out.println(new Solution().findsum(arr) == true ? "true" : "false");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        int n = arr.length;
        
        int[] dp = new int[n];
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            
            if(i==0) dp[0] = arr[0];
            else dp[i] = arr[i] + dp[i-1];
            
            if(set.contains(dp[i]) || dp[i]==0) return true;
            
            set.add(dp[i]);
        }
        
        return false;
    }
 
}