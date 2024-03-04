class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int maxScore=0;
        Arrays.sort(tokens);
        int i=0,j=tokens.length-1,score=0;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i++];
                score++;
                maxScore=Math.max(score,maxScore);
            }
            else if(score>=1){
                power+=tokens[j--];
                score--;
            }
            else return maxScore;
        }
        return maxScore;
    }
}