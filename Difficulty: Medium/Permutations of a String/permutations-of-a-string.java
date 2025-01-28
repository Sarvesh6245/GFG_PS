//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        Set<String> uniquePermutations = new HashSet<>();

        permute(s, "", uniquePermutations);

        ArrayList<String> result = new ArrayList<>(uniquePermutations);
        return result;
    }

    private void permute(String s, String prefix, Set<String> uniquePermutations) {
        if (s.length() == 0) {
            uniquePermutations.add(prefix);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            String remaining = s.substring(0, i) + s.substring(i + 1);

            permute(remaining, prefix + current, uniquePermutations);
        }
    }

}