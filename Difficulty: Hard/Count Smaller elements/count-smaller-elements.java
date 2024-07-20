//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] constructLowerArray(int[] arr) {
        // code here
     int n = arr.length;
        int[] result = new int[n];
        ElementIndex[] elements = new ElementIndex[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new ElementIndex(arr[i], i);
        }
        mergeSort(elements, 0, n - 1, result);
        return result;
    }

    private void mergeSort(ElementIndex[] elements, int low, int high, int[] result) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(elements, low, mid, result);
        mergeSort(elements, mid + 1, high, result);

        merge(elements, low, mid, high, result);
    }

    private void merge(ElementIndex[] elements, int low, int mid, int high, int[] result) {
        int left = low, right = mid + 1;
        List<ElementIndex> temp = new ArrayList<>();
        int count = 0;

        while (left <= mid && right <= high) {
            if (elements[left].value <= elements[right].value) {
                result[elements[left].index] += count;
                temp.add(elements[left++]);
            } else {
                count++;
                temp.add(elements[right++]);
            }
        }

        while (left <= mid) {
            result[elements[left].index] += count;
            temp.add(elements[left++]);
        }

        while (right <= high) {
            temp.add(elements[right++]);
        }

        for (int i = low; i <= high; i++) {
            elements[i] = temp.get(i - low);
        }
    }

    class ElementIndex {
        int value;
        int index;

        ElementIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}