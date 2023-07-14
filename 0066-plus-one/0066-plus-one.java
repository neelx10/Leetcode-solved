class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1] += 1;
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry > 0) {
            int[] result = new int[n + 1];
            result[0] = carry;
            for (int i = 1; i <= n; i++) result[i] = digits[i - 1];
            return result;
        }
        return digits;
    }
}