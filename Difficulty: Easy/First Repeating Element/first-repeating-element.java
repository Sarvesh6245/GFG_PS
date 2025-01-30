//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.firstRepeated(arr));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int firstRepeated(int[] arr) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++){
            if(hp.containsKey(arr[i])){
                min = Math.min(min,hp.get(arr[i]));
            } else {
                hp.put(arr[i], i+1);
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
