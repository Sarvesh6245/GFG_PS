//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // add your code here
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = mid(head);
        Node second = mid.next;
        mid.next = null;
        second.prev = null;
        head = sortDoubly(head);
        second = sortDoubly(second);
        return mergeLists(head, second);
    }
    
    private static Node mergeLists(Node node1, Node node2) {
        Node dummy = new Node(-1);
        Node result = dummy;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                dummy.next = node1;
                node1.prev = dummy;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2.prev = dummy;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }
        if (node1 != null) {
            dummy.next = node1;
            node1.prev = dummy;
        }
        if (node2 != null) {
            dummy.next = node2;
            node2.prev = dummy;
        }
        if (result.next != null) {
            result.next.prev = null;
        }
        return result.next;
    }
    
    private static Node mid(Node node) {
        Node slow = node;
        Node fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}