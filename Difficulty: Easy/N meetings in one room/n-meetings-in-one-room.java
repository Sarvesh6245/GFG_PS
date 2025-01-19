//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        List<Node> list = new ArrayList<>();
        for(int i=0; i<start.length; i++){
            list.add(new Node(start[i], end[i]));
        }
        
        Collections.sort(list, (a, b) -> Integer.compare(a.end, b.end));
        
        int begin = list.get(0).start;
        int close = list.get(0).end;
        int count =1;
        
        for(int i=1; i<list.size(); i++){
            if(list.get(i).start>close){
                count++;
                begin =list.get(i).start;
                close = list.get(i).end;
            }
        }return count;

        
    }
    
    class Node{
        int start;
        int end;
        
        public Node(int start, int end){
            this.start = start;
            this.end = end;
            
        }
    }
}
