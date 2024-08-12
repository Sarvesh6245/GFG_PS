//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
    ArrayList<Integer> list=new ArrayList<>();
        int i=0;
        int j=0;
        int n=arr1.length;
        int m=arr2.length;
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]) list.add(arr1[i++]);
            else list.add(arr2[j++]);
        }
        
        while(i<n){
            list.add(i++);
        }
        while(j<n){
            list.add(j++);
        }
        int sum=n+m;
         int mid=sum/2;
        if(sum%2==0){
           
            return (list.get(mid-1)+list.get(mid));
        }
        else{
            return (list.get(mid-1));
        }
    }
}



//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends