class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            int len = s.length();           
            sb.append(len).append('#').append(s);
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) { // 0 < 10
            // Find the position of '#' after the length
            int j = i; //  j = 0
            while (str.charAt(j) != '#') { // 
                j++;
            }
            
            // Extract the length if more than 10 go until string length and get integer
            int len = Integer.parseInt(str.substring(i, j));
            
            // Extract the actual string
            String word = str.substring(j + 1, j + 1 + len);
            result.add(word);
            
            // Move i to the next encoded string
            i = j + 1 + len;
        }
        
        return result;
    }
}