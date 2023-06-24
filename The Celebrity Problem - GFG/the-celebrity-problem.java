//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st=new Stack<>();
    	for(int i=0;i<n;i++) st.push(i);
    	
    	while(st.size()>1){
    	    int p1=st.pop();
    	    int p2=st.pop();
    	    if(M[p1][p2]==1) st.push(p2);
    	    else st.push(p1);
    	}
    	if(st.isEmpty()) return -1;
    	
    	int celeb=st.pop();
    	for(int i=0;i<n;i++){
    	    if(celeb!=i && (M[celeb][i]==1 || M[i][celeb]==0)) return -1;
    	}
    	return celeb;
    }
}