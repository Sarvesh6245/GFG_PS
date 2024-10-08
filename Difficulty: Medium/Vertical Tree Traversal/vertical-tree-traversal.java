//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static class pair{
        Node node;
        int ind;
        public pair(Node node, int ind){
            this.node=node;
            this.ind=ind;
        }
    }
    static ArrayList <Integer> verticalOrder(Node root){
        TreeMap<Integer, ArrayList<Integer>> map=new TreeMap<>();
        ArrayDeque<pair> dq=new ArrayDeque<>();
        dq.add(new pair(root,0));
        while(!dq.isEmpty()){
            pair rem=dq.remove();
            int i1=rem.ind;
            if(map.containsKey(i1)){
                map.get(i1).add(rem.node.data);
            }else {
                map.put(i1, new ArrayList<>());
                map.get(i1).add(rem.node.data);
            }
            if(rem.node.left!=null)dq.add(new pair(rem.node.left,i1-1));
            if(rem.node.right!=null)dq.add(new pair(rem.node.right,i1+1));
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int key:map.keySet()) {
        	for(Integer a: map.get(key)) {
        		ans.add(a);
        	}
        }
        return ans;
    }
}