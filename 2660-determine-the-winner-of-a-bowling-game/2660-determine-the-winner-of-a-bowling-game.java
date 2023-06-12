class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int sum1=player1[0], sum2=player2[0];
        for(int i=1; i<player1.length; i++){
            if(i==1){
                if(player1[i-1]==10) sum1+=2*player1[i];
                else sum1+=player1[i];
                
                if(player2[i-1]==10) sum2+=2*player2[i];
                else sum2+=player2[i];
            }
            else{
                if(player1[i-1]==10 || player1[i-2]==10) sum1+=2*player1[i];
                else sum1+=player1[i];
                
                if(player2[i-1]==10 || player2[i-2]==10) sum2+=2*player2[i];
                else sum2+=player2[i];
            }      
        }
        if(sum2>sum1) return 2;
        else if(sum1>sum2) return 1;
        return 0;
    }
}