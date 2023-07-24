//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    public void sorting(Stack<Integer> s,int temp){
        if(s.isEmpty()||s.peek()<=temp){
            s.push(temp);
            return;
        }
        int temp1=s.pop();
        sorting(s,temp);
        s.push(temp1);
    }
    
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s.isEmpty()) return s;
		int temp=s.pop();
		Stack<Integer> st=sort(s);
		sorting(s,temp);
		return st;
	}
}