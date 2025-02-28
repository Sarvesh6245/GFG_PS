//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public static boolean isOp(String curr){
        return Objects.equals(curr, "+") || Objects.equals(curr, "-") || Objects.equals(curr, "/") || Objects.equals(curr, "*");
    }
    public int evaluate(String[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            String curr = arr[i];
            if(isOp(curr)){
                int pop1 = st.pop();
                int pop2 = st.pop();
                if(curr.equals("+")) st.push(pop1 + pop2);
                if(curr.equals("*")) st.push(pop1 * pop2);
                if(curr.equals("/")) st.push(pop2 / pop1);
                if(curr.equals("-")) st.push(pop2 - pop1);
            }
            else{
                st.push(Integer.parseInt(curr));
            }
        }
        return st.peek();
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends