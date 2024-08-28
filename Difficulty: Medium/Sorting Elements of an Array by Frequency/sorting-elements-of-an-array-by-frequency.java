//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // map.forEach((k, v) -> System.out.println(k + ":" + v));
        Map<Integer, Integer> sortedMap = map.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.<Integer, Integer>comparingByValue()).
                thenComparing(Map.Entry.comparingByKey()))
            .collect(java.util.stream.Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));
        // sortedMap.forEach((k, v) -> System.out.println(k + ":" + v));
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> m : sortedMap.entrySet()) {
            int k = m.getKey();
            int v = m.getValue();
            for(int i=0; i<v; i++) {
                ans.add(k);
            }
        }
        
        return ans;
    }
}



//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends