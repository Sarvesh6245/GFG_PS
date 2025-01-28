//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        boolean[] dp = new boolean[n];
        int si = 0;
        int ei = n - 1;
        HashMap<String, Integer> edgeIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int src = edges[i][0] - 1;
            int dest = edges[i][1] - 1;
            graph[src].add(dest);
            graph[dest].add(src);
            edgeIndex.put(src + "," + dest, i);
            edgeIndex.put(dest + "," + src, i); 
        }

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (!dp[mid]) {
                if (gospherHack(graph, n, mid, m, edgeIndex)) {
                    ei = mid - 1;
                    dp[mid] = true;
                } else {
                    si = mid + 1;
                }
            } 
        }
        for(int i = 0; i < n; i++){
            if(dp[i]) return i;
        }

        return -1;
    }

    private static boolean gospherHack(ArrayList<Integer>[] graph, int n, int k, int m, HashMap<String, Integer> edgeIndex) {
        if (k == 0) return false;
        int set = (1 << k) - 1;
        int limit = (1 << n);

        boolean[] vis = new boolean[m];

        
        while (set < limit) {
            Arrays.fill(vis, false);

            for (int i = 0; i < n; i++) {
                if ((set & (1 << i)) != 0 && graph[i] != null) { 
                    for (int neighbor : graph[i]) {
                        String edge = i + "," + neighbor;
                        int index = edgeIndex.get(edge);
                        vis[index] = true; 
                    }
                }
            }

            boolean allCovered = true;
            for (boolean covered : vis) {
                if (!covered) {
                    allCovered = false;
                    break;
                }
            }

            if (allCovered) return true;

            int c = set & -set;
            int r = set + c;
            set = (((r ^ set) >>> 2) / c) | r;
        }

        return false;
    }
}
        
