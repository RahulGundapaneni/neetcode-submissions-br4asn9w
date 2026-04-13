class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = s.length();
        int maxSub = 0;
        int leftI = 0;

        for(int i = 0;i < l; i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) >= leftI) {
                    System.out.println("Check");
                    leftI = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i);
            maxSub = Math.max(maxSub, i - leftI + 1 );
        }
        return maxSub;
    }
}
