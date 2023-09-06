//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        if (start == end) return 0;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(); 
        q.offer(start);
        map.put(start, 0);
        while (!q.isEmpty()) {
            int temp = q.poll();
            int currentSteps = map.get(temp);
            for (int num : arr) {
                int newStart = (temp * num) % 100000;
                if (newStart == end) return currentSteps+1;
                if (!map.containsKey(newStart)) {
                    q.offer(newStart);
                    map.put(newStart, currentSteps + 1);
                }
            }
        }
        return -1; 
    }
}
