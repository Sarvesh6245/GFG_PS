//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		
System.out.println("~");
}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public ArrayList<String> helper(String p, String up){
          if(up.isEmpty()){
             ArrayList<String> list = new ArrayList<>();
            if(!list.contains(p)){
              list.add(p);
            }
              return list;
          }
          
           ArrayList<String> ans = new ArrayList<>();
          char ch = up.charAt(0);
          for(int i =0; i <= p.length(); i++){
              String f = p.substring(0,i);
              String e = p.substring(i,p.length());
              ans.addAll(helper(f+ch+e,up.substring(1)));
          }
          Collections.sort(ans);
          return ans;
      }
    
    
    public ArrayList<String> permutation(String S)
    {
       return  helper("", S);
 
    }
   
}
