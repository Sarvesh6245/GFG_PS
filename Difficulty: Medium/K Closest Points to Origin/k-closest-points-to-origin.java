//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public double sqrtfun(int x1, int x2, int y1, int y2){
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
    public int[][] kClosest(int[][] points, int k) {
        TreeMap<Double, ArrayList<int[]>> map = new TreeMap<>();
        for(int i=0;i<points.length;i++){
            int x1 = 0;
            int y1 = 0;
            int x2 = points[i][0];
            int y2 = points[i][1];
            
            double val = sqrtfun(x1, x2, y1, y2);
            
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(points[i]);
        }
        
        int[][] ans = new int[k][2];
        int idx = 0;
        while(k > 0){
            for(ArrayList<int[]> list: map.values()){
                for(int[] point: list){
                    ans[idx] = point;
                    k--;
                    idx++;
                    if(k==0){
                        break;
                    }
                }
                if(k==0){
                    break;
                }
            }
        }
        return ans;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends