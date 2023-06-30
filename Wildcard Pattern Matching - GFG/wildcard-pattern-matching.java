//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int solve(int ind1,int ind2, String s1, String s2,int[][] dp){
        if(ind1==0 && ind2==0) return 1;
        if(ind1==00 && ind2>0) return 0;
        if(ind1>0 && ind2==0){
            for(int it=0;it<=ind1-1;it++) if(s1.charAt(it)!='*') return 0;
            return 1;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1-1)==s2.charAt(ind2-1) || s1.charAt(ind1-1)=='?') return dp[ind1][ind2]=solve(ind1-1,ind2-1,s1,s2,dp);
        else if(s1.charAt(ind1-1)=='*'){
            return dp[ind1][ind2]=(solve(ind1-1,ind2,s1,s2,dp)==1 || solve(ind1,ind2-1,s1,s2,dp)==1)?1:0;
        }
        else return dp[ind1][ind2]=0;
    }
    
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        int m=pattern.length();
        int n=str.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(m,n,pattern,str,dp);
    }
}
