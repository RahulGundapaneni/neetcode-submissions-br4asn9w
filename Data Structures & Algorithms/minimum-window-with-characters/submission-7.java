class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        int l = 0;
        int minLen = Integer.MAX_VALUE;             
        int start = 0;
        int count = map.size();    

        for(int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            if(map.containsKey(curr)) {
                 map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) count--;        
            }                        
            while (count == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}