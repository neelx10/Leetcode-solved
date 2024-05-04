class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int i=0,j=n-1,count=0;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
            }
            else j--;
            count++;
        }
        return count;
    }
}