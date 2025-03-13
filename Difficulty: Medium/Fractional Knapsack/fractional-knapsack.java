//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution 
{
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int W) 
    {
        int n = wt.size();
        List<Item> items = new ArrayList<>();
        // Create list of items with value, weight, and per unit value
        for (int i = 0; i < n; i++) {
            double perUnitValue = (double) val.get(i) / wt.get(i);
            items.add(new Item(val.get(i), wt.get(i), perUnitValue));
        }
        // Sort items by per unit value in descending order
        Collections.sort(items, (a, b) -> Double.compare(b.perUnitValue, a.perUnitValue));
        double cost = 0;
        for (Item item : items) 
        {
            if (item.weight <= W) 
            {
                // Take the full item
                cost += item.value;
                W -= item.weight;
            } else 
            {
                // Take the fractional part of the item
                cost += W * item.perUnitValue;
                break; // No more capacity left
            }
        }
        return cost;
    }
}
// Helper class to store item details
class Item 
{
    int value;
    int weight;
    double perUnitValue;
    Item(int value, int weight, double perUnitValue) 
    {
        this.value = value;
        this.weight = weight;
        this.perUnitValue = perUnitValue;
    }
}