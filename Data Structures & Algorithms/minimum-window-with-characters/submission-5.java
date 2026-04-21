class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();  // required map from t
        int l = s.length();
        int l2 = t.length();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int minLen = Integer.MAX_VALUE;

        // For each possible starting position i
        for (int i = 0; i < l; i++) {

            // Create a new map (copy) for this window attempt
            HashMap<Character, Integer> newMap = new HashMap<>(map);

            // Expand from i onwards
            for (int j = i; j < l; j++) {

                char c = s.charAt(j);

                // If this char is in newMap, remove/decrement it
                if (newMap.containsKey(c)) {
                    if (newMap.get(c) == 1) {
                        newMap.remove(c);        // remove element if count becomes 0
                    } else {
                        newMap.put(c, newMap.get(c) - 1);
                    }
                }

                // If newMap is empty → we found a valid window
                if (newMap.isEmpty()) {
                    int currentLen = j - i + 1;
                    if (currentLen < minLen) {
                        minLen = currentLen;
                        result = s.substring(i, j + 1);
                    }
                    break;   // no need to expand further for this starting i
                }
            }
        }

        return result;
    }
}