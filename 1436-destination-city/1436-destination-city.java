class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map=new HashMap<>();
        for(List<String> path:paths) map.put(path.get(0),path.get(1));
        for(String city:map.values()){
            if(!map.containsKey(city)) return city;
        }
        return "";
    }
}