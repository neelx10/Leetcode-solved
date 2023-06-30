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
    boolean isAllStars(String S1, int i) {
        for (int j = 1; j <= i; j++){
          if (S1.charAt(j - 1) != '*') return false;
        }
        return true;
    }
    
    int wildCard(String s1, String s2)
    {
        // Your code goes here
        int m=s1.length();
        int n=s2.length();
        int[][] dp=new int[m+1][n+1];
        
        dp[0][0]=1;
        for(int ind1=1;ind1<=m;ind1++) dp[ind1][0]=(isAllStars(s1,ind1))?1:0;

        for(int ind1=1;ind1<=m;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1) || s1.charAt(ind1-1)=='?') dp[ind1][ind2]=dp[ind1-1][ind2-1];
                else if(s1.charAt(ind1-1)=='*') dp[ind1][ind2]=(dp[ind1-1][ind2]==1 || dp[ind1][ind2-1]==1)?1:0;
                else dp[ind1][ind2]=0;
            }
        }
        return dp[m][n];
    }
}












