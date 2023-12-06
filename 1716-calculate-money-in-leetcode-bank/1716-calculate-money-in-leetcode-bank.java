class Solution {
    public int totalMoney(int n) {
        int arithmeticSum = (n/7) * (28 + 28 + ((n/7)-1)*7) / 2;
        int finalWeek = 0;
        for (int day = 0; day < n % 7; day++) finalWeek += (1+(n/7)) + day;
        return arithmeticSum + finalWeek;
    }
}