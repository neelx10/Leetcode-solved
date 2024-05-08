class Solution {
    public String[] findRelativeRanks(int[] score) {
        int N = score.length;
        int M = 0;
        for (int s : score) {
            if (s > M) M = s;
        }
        int[] scoreToIndex = new int[M + 1];
        for (int i = 0; i < N; i++) scoreToIndex[score[i]] = i + 1;
        final String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] rank = new String[N];
        int place = 1;
        for (int i = M; i >= 0; i--) {
            if (scoreToIndex[i] != 0) {
                int originalIndex = scoreToIndex[i] - 1;
                if (place < 4) rank[originalIndex] = MEDALS[place - 1];
                else rank[originalIndex] = String.valueOf(place);
                place++;
            }
        }
        return rank;
    }
}