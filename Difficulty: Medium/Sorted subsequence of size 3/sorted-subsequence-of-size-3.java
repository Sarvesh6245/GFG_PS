//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
    List<Integer> ans = new ArrayList<>();
        int len = arr.length;
        if(len < 3) return ans;
        int small[] = new int[len];
        int big[] = new int[len];
        small[0] = arr[0];
        for(int i =1;i<len;i++){
            if(arr[i]>small[i-1]){
                small[i] = small[i-1];
            }else{
                small[i] = arr[i];
            }
        }
        big[len-1] = arr[len-1];
        for(int i =len-2;i>=0;i--){
            if(arr[i]>big[i+1]){
                big[i] = arr[i];
            }else{
                big[i] = big[i+1];
            }
        }
        for(int i=0;i<len;i++){
            if(small[i]<arr[i] && arr[i]<big[i]){
                ans.add(small[i]);
                ans.add(arr[i]);
                ans.add(big[i]);
                return ans;
            }
        }
        return ans;
    }
}

