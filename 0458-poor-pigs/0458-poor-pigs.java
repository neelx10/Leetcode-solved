class Solution {
    public int poorPigs(int buckets, int timeDie, int timeTest) {
        int test = timeTest/timeDie,i=0;
        while(Math.pow(test+1,i)< buckets) i++;
        return i;
    }
}