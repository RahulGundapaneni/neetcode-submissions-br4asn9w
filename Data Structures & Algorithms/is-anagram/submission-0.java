class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        
        if(Arrays.equals(sArray, tArray)){
            return true;
        }
        return false;
    }
}
