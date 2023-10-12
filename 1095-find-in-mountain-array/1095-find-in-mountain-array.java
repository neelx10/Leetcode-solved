/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
     public int BS1(MountainArray mountainArr,int target,int lastIndex){
            int start=0;
            int end=lastIndex;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(target<mountainArr.get(mid)){
                    end=mid-1;
                }
                else if(target>mountainArr.get(mid)){
                    start=mid+1;
                }
                else {
                    return mid;
                }
            }
            return -1;
        }
        public int BS2(MountainArray mountainArr,int target,int lastIndex){
            int start=lastIndex+1;
            int end=mountainArr.length()-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(target>mountainArr.get(mid)){
                    end=mid-1;
                }
                else if(target<mountainArr.get(mid)){
                    start=mid+1;
                }
                else {
                    return mid;
                }
                
            }
            return -1;
        }
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int start=0;
            int end=mountainArr.length()-1;
            while(start<end){
                int mid=start+(end-start)/2;
                if(mountainArr.get(mid)>mountainArr.get(mid+1)) end=mid;
                else start=mid+1;
            }
            int a= BS1(mountainArr,target,start);
            if(a!=-1) return a;
            int b= BS2(mountainArr,target,start);
            if(a == -1 || b == -1) return Math.max(a,b);
            else return Math.min(a,b);
        }
}