//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for(int i=0;i<K;i++)
        {
            adj.add(new ArrayList<>());
        }
        //int prev=0;
        for(int curr=1;curr<N;curr++)
        {
            int stringIndex = 0;
            try{
                while(dict[curr].charAt(stringIndex) == dict[curr-1].charAt(stringIndex))
                    {
                    stringIndex++;
                    }
                char pointedFrom=' ' , pointedTo=' ';
                
                    pointedFrom = dict[curr-1].charAt(stringIndex);
                
                    pointedTo = dict[curr].charAt(stringIndex);
                  
                    adj.get(pointedFrom - 97).add(pointedTo);
            }
            catch(Exception e){
                
            }
            
        }
        //System.out.println(adj.toString());
        return topologicalSort(adj,K);
        
    }
    public String topologicalSort(ArrayList<ArrayList<Character>> adj,int K)
    {
        char[] ans = new char[K];
        Queue<Character> que = new ArrayDeque<>();
        int[] inDegree = new int[K];
        for(int i=0;i<K;i++){
            for(char adjacent : adj.get(i)){
                inDegree[adjacent - 97] +=1;
            }
        }
        for(int i=0;i<K;i++){
            if(inDegree[i] == 0)
                que.add((char)(i+97));
        }
        int index = 0;
        while(!que.isEmpty()){
            char curr = que.remove();
            
            for(char adjacent : adj.get(curr-97))
            {
                inDegree[adjacent-97] -=1;
                
                if(inDegree[adjacent-97] == 0)
                    que.add(adjacent);
            }
            ans[index] = curr;
            index++;
            
        }
       //System.out.println(new String(ans)); 
       return new String(ans); 
        
    }
}

