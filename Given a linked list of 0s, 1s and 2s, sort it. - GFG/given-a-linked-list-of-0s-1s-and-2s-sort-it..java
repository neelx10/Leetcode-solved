//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node mergeTwoLists(Node list1, Node list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.data>list2.data){
            Node temp=list1;
            list1=list2;
            list2=temp;
        }
        Node res=list1;
        while(list1!=null && list2!=null){
            Node temp=null;
            while(list1!=null && list1.data<=list2.data){
                temp=list1;
                list1=list1.next;
            }
            temp.next=list2;
            //swapping
            Node tmp=list1;
            list1=list2;
            list2=tmp;
        }
        return res;
    }
    
    static Node segregate(Node head)
    {
        // add your code here
        if(head==null || head.next==null) return head;
        //finding middle of LL
        Node temp=null,slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        
        //recursive calls
        Node l1=segregate(head);
        Node l2=segregate(slow);
        
        //merging the 2 sorted LL's
        return mergeTwoLists(l1,l2);
    }
}


