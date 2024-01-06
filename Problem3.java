class Solution {
    public int lengthOfLongestSubstring(String s) {
        // pw kge w
      int maxLen = 0;

      if (s.length() == 0) {
          return maxLen;
      }
      Set<Character> alreadyExistinggChar = new LinkedHashSet<>();
 
      for (int i = 0; i < s.length(); i++) {
          if (alreadyExistinggChar.contains(s.charAt(i))) {
             for (Character c : alreadyExistinggChar) {
                 alreadyExistinggChar.remove(c);
                 if (c.equals(s.charAt(i))) {
                    break;
                 }
             }
          }
          alreadyExistinggChar.add(s.charAt(i));
          maxLen = alreadyExistinggChar.size() > maxLen ?
          alreadyExistinggChar.size() : maxLen;
      }

      return maxLen;

    }
}
