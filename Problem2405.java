class Solution {
    public int partitionString(String s) {
        
   


      Set<Character> set = new HashSet<>();
      set.add(s.charAt(0));

      int totalCount = 1;
      //aaabca
      for (int i = 1 ;i < s.length(); i++) {
          if (set.contains(s.charAt(i))) {
              set.clear();
              totalCount++;
          }
          set.add(s.charAt(i));
      }
      return totalCount;
    }
}
