class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        char cha[] = s.toCharArray();
        int result = 0;
        int left = 0;
        int right = 0;

        for(char c: cha) {
            if(set.contains(c)) {
                while(left <= right) {
                    if(cha[left] == c) {
                        set.remove(c);
                        left++;
                        break;
                    }
                    set.remove(cha[left]);  
                    left++;
                }
            }
            set.add(c);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
