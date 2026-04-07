class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n = s.length();
        int p = t.length();
        if(n != p) return false;

        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        for(int i = 0; i < n; i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }

        int mapSize = map.size();
        int mapSize2 = map2.size();

        if(mapSize != mapSize2) return false;
        for(char a : map.keySet()){
            if (!map.get(a).equals(map2.get(a))) return false;
        }
        return true;
    }
}
