//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int nextHappy(int N){
        while(true){
            if(isHappy(++N)) return N;
        }
    }
        
    static boolean isHappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow=findsquare(slow);
            fast=findsquare(findsquare(fast));
        } while (slow != fast);
        if (slow == 1){
            return true;
        }
        return false;
    }

    static int findsquare(int number){
        int ans=0;
        while(number>0){
            int rem = number % 10;
            ans += rem*rem;
            number/=10;
        }
        return ans;
    }
}