class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx=map.get(val);
        map.remove(val);
        if(idx==list.size()-1) list.remove(idx);
        else{
            list.set(idx,list.get(list.size()-1));
            list.remove(list.size()-1);
            map.put(list.get(idx),idx);
        }
        return true;
    }
    
    public int getRandom() {
        int temp=rand.nextInt(list.size());
        return list.get(temp);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */