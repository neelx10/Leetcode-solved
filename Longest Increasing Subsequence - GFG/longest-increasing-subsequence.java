//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int bs(int t,ArrayList<Integer> list){
        int start=0;
        int end=list.size()-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(list.get(mid)>=t) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
    
    static int longestSubsequence(int size, int a[])
    {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        int count=1;
        list.add(a[0]);
        for(int i=1;i<size;i++){
            if(a[i]>list.get(list.size()-1)){
                list.add(a[i]);
                count++;
            }
            else list.set(bs(a[i],list),a[i]);
        }
        return count;
    }
} 