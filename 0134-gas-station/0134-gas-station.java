class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int total_gas=0,total_cost=0;
        for(int i=0;i<n;i++){
            total_gas+=gas[i];
            total_cost+=cost[i];
        }
        if(total_cost>total_gas) return -1;
        int gas_in_car=0,start=0;
        for(int i=0;i<n;i++){
            gas_in_car+=gas[i];
            gas_in_car-=cost[i];
            if(gas_in_car<0){
                start=i+1;
                gas_in_car=0;
            }
        }
        return start;
    }
}