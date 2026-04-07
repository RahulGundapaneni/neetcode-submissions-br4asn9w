class Solution {
    public boolean isAnagram(String s, String t) {

        int n = s.length();
        int p = t.length();
        if(n != p) return false;

        int[] a = new int[26];

        for(int i = 0; i < n; i++) {
            a[s.charAt(i)-'a'] = a[s.charAt(i)-'a'] + 1;
            a[t.charAt(i)-'a'] = a[t.charAt(i)-'a'] - 1;
        }

        for(int i: a){
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
