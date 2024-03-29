//{ Driver Code Starts
// C++ program to evaluate value of a postfix expression

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
    //Function to evaluate a postfix expression.
    int evaluatePostfix(string S)
    {
        // Your code here
        stack<int> st;
        for (auto it : S) {
            if (it == '+' || it == '-' || it == '*' || it == '/') {
                int second = st.top();
                st.pop();
                int first = st.top();
                st.pop();
                if (it == '+')
                    st.push(first + second);
                else if (it == '-')
                    st.push(first - second);
                else if (it == '*')
                    st.push(first * second);
                else if (it == '/')
                    st.push(first / second);
            } else {
                int num = it - '0'; // Convert character to numeric value
                st.push(num);
            }
        }
        return st.top();

    }
};

//{ Driver Code Starts.

// Driver program to test above functions
int main()
{
    int t;
    cin>>t;
    cin.ignore(INT_MAX, '\n');
    while(t--)
    {
        string S;
        cin>>S;
        Solution obj;
    
    cout<<obj.evaluatePostfix(S)<<endl;
    }
    return 0;
}

// } Driver Code Ends