//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(arr));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxSumIS(int arr[]) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];  // Initialize the dp array
        int result = arr[0];  // Track the maximum sum

        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i];  // Initially, each element is a subsequence on its own
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i])  // Check if arr[i] can extend the subsequence
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);  // Maximize the sum
            }
            result = Math.max(result, dp[i]);  // Update the result with the max sum found
        }
        return result;  // Return the maximum sum of the increasing subsequence
    }
}