//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int count =0;
        int tempHigh = arr.length-1;
        for(int i=0; i <= arr.length-2;i++){
            int low = i;
            int high = tempHigh;
            int requiredTarget = target - arr[i];
            while(low < high){
                if(arr[high] >= requiredTarget){
                    high--;
                }else if(arr[high] < requiredTarget){
                    if(count == 0){
                        tempHigh = high;
                    }
                    count++;
                    high--;
                }
            }
        }
        return count;
    }
}



//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends