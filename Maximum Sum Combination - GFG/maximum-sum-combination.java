//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Pair{
    int i,j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
    //why?
    public boolean equals(Object o)
        {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair)o;
            return (i == obj.i && j == obj.j);
        }
 
         public int hashCode()
        {
            return Objects.hash(i, j);
        }
}

class Three implements Comparable<Three>{
    int val,i,j;
    
    public Three(int val,int i,int j){
        this.val=val;
        this.i=i;
        this.j=j;
    }
    
    //pq gives priority to the value(val) or sum.
    public int compareTo(Three p){
        return p.val-this.val;
    }
}

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        List<Integer> list=new ArrayList<>();
        PriorityQueue<Three> pq=new PriorityQueue<Three>();
        HashSet<Pair> set=new HashSet<>();
        Arrays.sort(A);
        Arrays.sort(B);
        int i=N-1;
        int j=N-1;
        pq.add(new Three(A[i]+B[j],i,j));
        set.add(new Pair(i,j));
        for(int l=0;l<K;l++){
            Three p=pq.poll();
            list.add(p.val);
            //for i-1,j values
            int im=p.i - 1;
            int jm=p.j;
            if(im>=0 && jm>=0  && !set.contains(new Pair(im,jm))){
                set.add(new Pair(im,jm));
                pq.add(new Three(A[im]+B[jm],im,jm));
            }
            
            //for i,j-1 values
            im=p.i;
            jm=p.j - 1;
            if(im>=0 && jm>=0  && !set.contains(new Pair(im,jm))){
                set.add(new Pair(im,jm));
                pq.add(new Three(A[im]+B[jm],im,jm));
            }
        }
        return list;
    }
}
