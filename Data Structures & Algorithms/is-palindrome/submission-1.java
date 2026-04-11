class Solution {
    public boolean isPalindrome(String s) {
       int left = 0;
       int right = s.length()-1;
       while(left < right) {
        int leftChar = s.charAt(left);
        if(!Character.isLetterOrDigit(leftChar)){
            left++;
            continue;
        }
        if(Character.isLetter(leftChar)) leftChar = Character.toLowerCase(leftChar);
        int rightChar = s.charAt(right);
        if(!Character.isLetterOrDigit(rightChar)){
            right--;
            continue;
        }
        if(Character.isLetter(rightChar)) rightChar = Character.toLowerCase(rightChar);
        if(leftChar != rightChar) {
            return false;
        }
        System.out.println(leftChar);
        System.out.println(rightChar);
        left++;
        right--;
       } 
       return true;
    }
}
