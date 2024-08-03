//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    long n=ob.nextLong();
		    Solution ab=new Solution();
		    long k=ab.findNth(n);
		    System.out.println(k);
		}
	}
}

    

// } Driver Code Ends


//User function Template for Java

class Solution {
    long findNth(long n){
        long[] d = {0, 9, 81, 729, 6561, 59049, 531441, 4782969, 43046721,
                387420489, 3_486_784_401L, 31381059609L, 282429536481L};
        long a = n, ans = 0, temp, b;
        int i;
        for(i=0;i<d.length;i++){
            if(d[i] > a) break;
        }
        i--; // digits == i, d[i] == xxDigits
        while(a >= 9){
            b = d[i];
            temp = Math.floorDiv(a, b);
            ans += temp * Math.pow(10, i);
            a -= b*temp;
            i--;
        }
        return ans+a;
    }   
}

