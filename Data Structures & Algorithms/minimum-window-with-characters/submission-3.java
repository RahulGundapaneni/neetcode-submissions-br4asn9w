class Solution {
    public String minWindow(String s, String t) {
        // Brute force idea:
        // HashMap counter for substring, if hashMap is empty then check length and find at each position

        // outer loop: for then 
        // Inner loop: keep checking until 0 or empty
        // continue for complete string

        HashMap<Character, Integer> map = new HashMap<>();
        int l = s.length();
        int l2 = t.length();

        // Build frequency map for t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Window frequency map
        HashMap<Character, Integer> window = new HashMap<>();

        int required = map.size();   // number of unique chars we need to satisfy
        int formed = 0;              // how many we have satisfied so far

        int left = 0;                // your shrinking pointer (renamed from your 'l' to avoid conflict)
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Outer loop: expand right pointer
        for (int right = 0; right < l; right++) {
            
            char c = s.charAt(right);
            
            // Add current char to window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If this char is needed and we now have exactly the required count
            if (map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // Inner part: shrink from left while window is valid
            while (left <= right && formed == required) {
                
                // Update minimum window found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If we broke the requirement for a needed char
                if (map.containsKey(leftChar) && window.get(leftChar).intValue() < map.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}