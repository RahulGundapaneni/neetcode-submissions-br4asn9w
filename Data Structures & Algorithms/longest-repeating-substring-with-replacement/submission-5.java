class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int res = 0;
        int left = 0;
        int maxFreq = 0;

        for(int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(curr));

            // Shrink window if needed
            while((i - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}