//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        int map[]=new int[100001];
        for(Integer num:arr){
            map[num]++;
        }
        int cnt=0;
        int maxlen=0;
        for(Integer num:map){
            if(num==0){
                maxlen=Math.max(cnt,maxlen);
                cnt=0;
            }
            else{
                cnt++;
            }
        }
        
        
        return maxlen;
    }
}