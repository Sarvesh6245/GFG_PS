//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //visited array
        boolean [] visited = new boolean[V+1];
        //jaha se start karoge voh toh visited hoga hi n
        visited[0] = true;
        
        //for storing result of bfs
        ArrayList<Integer> ans = new ArrayList<>();
        
        //applying bfs method with relevant parameters
        bfs(0, adj, visited, ans);
        
        //dfs as returned in ArrayList<Integer> as asked in ques
        return ans;
    }
    
    void bfs(int u, ArrayList<ArrayList<Integer>> adj, boolean [] visited, ArrayList<Integer> ans){
        //storing nodes in queue for traversing
        Queue<Integer> q = new LinkedList<>();
        //starting pt ko add karoge tab n usse explore karoge
        q.offer(u);
        //marking the stsrting node as visited
        visited[u]= true;
        //adding the node to result Arraylist
        ans.add(u);
        
        //traverse jab tak queue empty na ho
        while(!q.isEmpty()){
            //top node of the queue is to be explored for its neighbours
            int node = q.peek();
            //poping the element to move onto the next element in queue in next traversal
            q.poll();
            
            //ab uss node ke neighbours ko traverse karenge
            //referring from the adjacency list of that node's index
            //typically, node=index in adj list
            for(int v: adj.get(node)){
                //if that neighbour is not visited
                if(!visited[v]){
                
                //queue mein add karne ka fxn
                q.offer(v);
                //uss neifghbour ko true mark kiya jo ki actually khud mein bhi ek node hi h
                visited[v] = true;
                //bfs ke result mein add kardiya side by side
                ans.add(v);
                }
            }
        }
        
            
                }
}  

