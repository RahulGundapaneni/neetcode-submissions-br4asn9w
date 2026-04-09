class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs) {
            sb.append(s).append('#').append(" ");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        int j = 0;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '#' && str.charAt(i+1) == ' ') {
                result.add(str.substring(j, j+(i-j)));
                j = i+2;
            }
        }
        return result;
    }
}
