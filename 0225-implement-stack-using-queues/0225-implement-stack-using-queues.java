class MyStack {
    List<Integer> q;
    public MyStack() {
        q=new ArrayList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int temp=top();
        q.remove(q.size()-1);
        return temp;
    }
    
    public int top() {
        return q.get(q.size()-1);
    }
    
    public boolean empty() {
        return q.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */