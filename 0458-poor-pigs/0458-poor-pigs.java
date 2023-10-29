class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testsPerPig = minutesToTest / minutesToDie,numPigs = 0, states = 1; // Number of unique states a pig can represent 
        while (states < buckets) {
            states *= (testsPerPig + 1);
            numPigs++;
        }
        return numPigs;
    }
}