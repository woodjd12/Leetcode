// Given two strings s and t, return true 
// if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the 
// letters of a different word or phrase, typically using a
// ll the original letters exactly once.
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        int map = 97;
        for (char ch : s.toCharArray()) {
            count[ch - map]++; 
        }
        for (char ch : t.toCharArray()) {
            count[ch - map]--; 
        }
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }
}
