//{ Driver Code Starts
// initial code
import java.lang.*;
import java.util.*;

class InterLeaveString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g = new Solution();

            System.out.println(g.isInterLeave(a, b, c) == true ? "true" : "false");
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
        //base case
        if (a.length() + b.length() != c.length()) {
            return false;
        }

        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        return combination(dp, a,b,c, 0, 0, 0) == 1 ? true : false;
	}

    private int combination(int[][] dp, String a, String b, String c, int ai, int bi, int ci) {
        if(ci == c.length()) return 1;
        if(dp[ai][bi] != -1) return dp[ai][bi];
        int take = 0;
        if(ai < a.length() && a.charAt(ai) == c.charAt(ci))
            take = combination(dp, a,b, c, ai+1, bi, ci+1);
        if(take == 0 && bi < b.length() && b.charAt(bi) == c.charAt(ci))
            take = combination(dp, a,b, c, ai, bi+1, ci+1);
        
        return dp[ai][bi] = take;
    }
}