//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        while (T-- > 0) {
            int n = sc.nextInt(); // Number of accounts
            ArrayList<ArrayList<String>> accounts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt(); // Number of emails + name
                ArrayList<String> temp = new ArrayList<>();
                for (int j = 0; j < x; j++) {
                    temp.add(sc.next()); // Read name/emails
                }
                accounts.add(temp);
            }

            // Calling the accountsMerge function
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> res = obj.accountsMerge(accounts);

            // Sorting individual accounts' emails
            for (int i = 0; i < res.size(); i++) {
                Collections.sort(res.get(i));
            }

            // Sorting the entire list exactly like C++'s sort(res.begin(), res.end());
            Collections.sort(res, new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> a, ArrayList<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        int cmp = a.get(i).compareTo(b.get(i));
                        if (cmp < 0) return -1;
                        if (cmp > 0) return 1;
                    }
                    if (al < bl) return -1;
                    if (al > bl) return 1;
                    return -1; // Exact match with C++ behavior
                }
            });

            // Printing the output in the required format
            System.out.print("[");
            for (int i = 0; i < res.size(); i++) {
                System.out.print("[");
                for (int j = 0; j < res.get(i).size(); j++) {
                    if (j != res.get(i).size() - 1) {
                        System.out.print(res.get(i).get(j) + ", ");
                    } else {
                        System.out.print(res.get(i).get(j));
                    }
                }
                if (i != res.size() - 1) {
                    System.out.println("], ");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println("]");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int V) {
        parent = new int[V];
        size = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int uPar = findUPar(u);
        int vPar = findUPar(v);
        if (uPar != vPar) {
            if (size[uPar] < size[vPar]) {
                parent[uPar] = vPar;
                size[vPar] += size[uPar];
            } else {
                parent[vPar] = uPar;
                size[uPar] += size[vPar];
            }
        }
    }
}

class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!hm.containsKey(mail)) {
                    hm.put(mail, i);
                } else {
                    ds.unionBySize(i, hm.get(mail));
                }
            }
        }

        ArrayList<TreeSet<String>> mergedAccounts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedAccounts.add(new TreeSet<>()); // Using TreeSet to keep emails sorted
        }

        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            int upNode = ds.findUPar(e.getValue());
            mergedAccounts.get(upNode).add(e.getKey());
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!mergedAccounts.get(i).isEmpty()) {
                ArrayList<String> temp = new ArrayList<>(mergedAccounts.get(i));
                temp.add(0, accounts.get(i).get(0)); // Add the name at index 0
                result.add(temp);
            }
        }

        return result;
    }
}
