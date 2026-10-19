class Solution {
    public boolean isAnagram(String s, String t) {
        int a[] = new int[26];
        int b[] = new int[26];

        for(int i = 0; i < 26; i++) {
            a[i] = 0;
            b[i] = 0;
        }

        int l1 = s.length();
        int l2 = t.length();
        if(l1 != l2) return false;

        for(int i = 0; i < l1; i++) {
            a[s.charAt(i)- 'a'] = a[s.charAt(i)- 'a'] + 1;
            b[t.charAt(i) - 'a'] = b[t.charAt(i) - 'a'] + 1;
        }
        if (Arrays.equals(a, b)) return true;
        return false;
     }
}
