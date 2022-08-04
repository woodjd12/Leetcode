/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
*/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        char[] ch = s.toCharArray();
        int len = ch.length;
        for (int i = 0; i < (len / 2); i++) {
            System.out.println(ch[i] + " " + ch[len - i - 1]);
            if (ch[i] != ch[len - i - 1]) {
                return false;
            }
        }
        return true;
            
    }
}
