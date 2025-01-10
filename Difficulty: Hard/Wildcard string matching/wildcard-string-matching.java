//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean f(int n,int m,String wild, String pattern)
    {
        
      if(n<0&&m<0){
          return true;
          
      }
       if(n<0&&m>=0){
          return false;
          
      }
      if(n>=0&& m<0){
          for(int i=0;i<n;i++){
              if(wild.charAt(i)!='*'){
                  return false;
                  
              }
          }
          return true;
          
      }
      if(wild.charAt(n)==pattern.charAt(m) || wild.charAt(n)=='?'){
          return f(n-1,m-1,wild,pattern);
          
      }
      if(wild.charAt(n)=='*'){
          return f(n-1,m,wild,pattern)||f(n,m-1,wild,pattern);
          
      }
      return false;
      
      
    }
    static boolean match(String wild, String pattern){
        
        int n = wild.length()-1;
        int m= pattern.length()-1;
        return f(n,m,wild,pattern);
        
    }
}