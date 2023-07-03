class Bank {
    int n;
    long[] arr;
    public Bank(long[] balance) {
        n=balance.length;
        arr=balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1>0 && account1<=n && account2>0 && account2<=n && arr[account1-1]>=money){
            arr[account1-1]-=money;
            arr[account2-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account>0 && account<=n){
            arr[account-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>0 && account<=n && arr[account-1]>=money){
            arr[account-1]-=money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */