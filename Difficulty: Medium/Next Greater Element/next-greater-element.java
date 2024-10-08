//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] res=new long[n];
        Stack<Long> st=new Stack<>();
        res[n-1]=-1;
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()!=0&&st.peek()<=arr[i]){
                st.pop();
            }
            res[i]=st.size()==0?-1:st.peek();
            st.push(arr[i]);
            
        }
        return res;
        
    } 
}