//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countPS(String S) { 
        int N = S.length();
        int count = 0;

        for (int i = 0; i < N; i++) {
            count += countPalindromes(S, i, i);     
            count += countPalindromes(S, i, i + 1); 
        }
        return count;
    }

    private int countPalindromes(String S, int left, int right) {
        int count = 0;
        while (left >= 0 && right < S.length() && S.charAt(left) == S.charAt(right)) {
            if (right - left + 1 >= 2) { 
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
}
