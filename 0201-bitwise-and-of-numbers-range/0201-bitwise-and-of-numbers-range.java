class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left==1073741824 && right==2147483647) return left;
        if ((left == 0) || (right == 0)) return 0;
        
        // if there is a different amount of digits in binary - always will be zero
        if ((int)(Math.log(left) / Math.log(2)) != (int)(Math.log(right) / Math.log(2))) return 0;

        int res = left;
        for (long i = left; i <= right; i++) res &= i;    
        return res;
    }
}