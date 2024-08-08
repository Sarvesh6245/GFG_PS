//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> dist = new HashMap<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        for (String word : wordList) {
            set.add(word);
        }

        Queue<String> q = new LinkedList<>();
        q.offer(startWord);
        dist.put(startWord, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(targetWord)) break;
            char[] charCur = cur.toCharArray();

            for (int i = 0; i < cur.length(); i++) {
                char c = charCur[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    charCur[i] = j;
                    String s = new String(charCur);
                    if (set.contains(s) && dist.get(s) == null) {
                        dist.put(s, dist.get(cur) + 1);
                        q.offer(s);
                    }
                }
                charCur[i] = c;
            }
        }

        if (dist.get(targetWord) == null) return res;

        List<String> path = new ArrayList<>();
        path.add(targetWord);
        dfs(targetWord, startWord, dist, res, path);

        return res;
    }

    private void dfs(String word, String startWord, Map<String, Integer> dist, ArrayList<ArrayList<String>> res, List<String> path) {
        if (word.equals(startWord)) {
            ArrayList<String> list = new ArrayList<>(path);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        char[] charCur = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char c = charCur[i];
            for (char j = 'a'; j <= 'z'; j++) {
                charCur[i] = j;
                String s = new String(charCur);
                if (dist.get(s) != null && dist.get(s) + 1 == dist.get(word)) {
                    path.add(s);
                    dfs(s, startWord, dist, res, path);
                    path.remove(path.size() - 1);
                }
            }
            charCur[i] = c;
        }
    }
}