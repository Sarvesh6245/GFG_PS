//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean find(int sum,int[] a,int n,int k,int currsum,boolean[] flag){
        if(currsum>sum){
            return false;
        }
        
        if(k==0){
            return true;
        }
        
        if(currsum==sum){
            return find(sum,a,n,k-1,0,flag);
        }
        
        for(int i=0; i<n; i++){
            if(!flag[i]){
                flag[i]=true;
                if(find(sum,a,n,k,currsum+a[i],flag)){
                    return true;
                }
                flag[i]=false;
            }
        }
        
        return false;
    }
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
        int sum=0;
        for(int i=0; i<a.length; i++){
            sum+=a[i];
        }
        
        if(k>n || sum%k!=0){
            return false;
        }
        
        boolean[] flag=new boolean[n];
        sum/=k;
        boolean ans=find(sum,a,n,k,0,flag);
        return ans;
    }
}