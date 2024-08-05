//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        // code here
        int[] lis = new int[n];
        int length = 0;
        if(n == 0) return 0;
        for(int i=0; i<n; i++){
            int pos = Arrays.binarySearch(lis, 0, length, a[i]);
            if(pos<0){
                pos = -(pos+1);
            }
            lis[pos] = a[i];
            if(pos == length){
                length++;
            }
        }
        return length;
    }
}