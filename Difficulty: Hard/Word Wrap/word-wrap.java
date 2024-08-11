//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int t[][] = new int[nums.length+1][k+2];
        for(int row[]:t)
        Arrays.fill(row,-1);
        return solve(nums,k,0,k,t);
    }
    int solve(int[] nums, int unusedSpace, int i, int k,int t[][])
    {
        // base condition
        if(i>=nums.length)
        return 0;
        if(t[i][unusedSpace+1]!=-1)
        return t[i][unusedSpace+1];
        
        int ans;
        
        
        if(unusedSpace-nums[i]<0){  //maan lo current space bcha hai 4, or maanlo word hai 5 lenght ka
        // tb to nhi ho payega na, to baki pure ko remaning space maan le rahe hai or fir calculate kr rhe hai
            ans = (unusedSpace+1)*(unusedSpace+1)+solve(nums,k-nums[i]-1,i+1,k,t); // maano 3 length hai, total word length 6 hai, lakin jb function call kiye hai tb k-nums[i]-1 krke call kiye hai us -1 ko pass krne k liye -1 ko use kiye.
        }
        else
        {
            int take = (unusedSpace+1)*(unusedSpace+1)+solve(nums,k-nums[i]-1,i+1,k,t); //-1 use kyu kiye kuki do word k bich mein ek gap hota hai usko fill krne k liye.
            int notTake = solve(nums,unusedSpace-nums[i]-1,i+1,k,t);
            ans =Math.min(take,notTake);
        }
        return t[i][unusedSpace+1] =ans;
        
    }
}