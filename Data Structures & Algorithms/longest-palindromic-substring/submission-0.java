class Solution {

    private int bestStart;
    private int bestLength;
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return "";
        }
        bestStart = 0;
        bestLength = 1;
        for(int center = 0; center < s.length();center++) {
            expandAroundCenter(s,center,center);
            expandAroundCenter(s,center, center+1);
        }
        return s.substring(bestStart, bestStart + bestLength);
        }  
        private void expandAroundCenter(String s, int left, int right) {
            while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int currentLength = right - left - 1;
            if(currentLength > bestLength) {
                bestStart = left + 1;
                bestLength = currentLength;
        }
    }
}
