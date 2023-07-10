//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int matrix[][], int n, int m, int k){
        int top=0,down=n-1,left=0,right=m-1;
        while(top<=down && left<=right){
            for(int i=left;i<=right;i++){
                k--;
                if(k==0) return matrix[top][i];
            }
            top++;
            
            for(int i=top;i<=down;i++){
                k--;
                if(k==0) return matrix[i][right];
            }
            right--;
            
            for(int i=right;i>=left;i--){
                k--;
                if(k==0) return matrix[down][i];
            }
            down--;
            
            for(int i=down;i>=top;i--){
                k--;
                if(k==0) return matrix[i][left];
            }
            left++;
        }
        return -1;
    }
}