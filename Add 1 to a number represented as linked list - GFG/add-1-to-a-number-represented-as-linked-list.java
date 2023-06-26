//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverseList(Node head) {
        Node curr=head,th=null;
        while(curr!=null){
            Node fw=curr.next;
            curr.next=null;
            if(th==null) th=curr;
            else{
                curr.next=th;
                th=curr;
            }
            curr=fw;
        }
        return th;
    }
    
    public static Node addOne(Node head) 
    { 
        //code here.
        head=reverseList(head);
        
        Node dummy = new Node(0); 
        Node temp = dummy;
        
        Node temp1=head;
        int carry = 0;
        int sum=temp1.data+1;
        temp1=temp1.next;
        carry=sum/10;
        Node start=new Node(sum%10);
        temp.next=start;
        temp=temp.next;
        
        while(temp1!=null || carry==1){
            sum=0;
            if(temp1!=null){
                sum+=temp1.data;
                temp1=temp1.next;
            }
            sum+=carry;
            carry=sum/10;
            Node newNode=new Node(sum%10);
            temp.next=newNode;
            temp=temp.next;
        }
        
        return reverseList(dummy.next);
    }
}
