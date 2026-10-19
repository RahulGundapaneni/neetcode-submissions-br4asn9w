class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l1 = s.length();
        int l2 = t.length();

        if(l1 != l2) return false;

        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }
        for(char c2: t.toCharArray()) {
            if(map.containsKey(c2)) {
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0) map.remove(c2);
            } else {
                return false;                  
            }
        }
        if(!map.isEmpty()) return false;
        return true;

    }
}
