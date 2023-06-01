class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
            abcde
              ace

              abcd
                ac

                xyz
                ybz
        */
        Map<String, Integer> longSubSequenceByIndexes = new HashMap<>();
        return getLongestCommonSubsequence(text1, text1.length() -1 ,text2, text2.length() -1 ,longSubSequenceByIndexes);

    }

    int getLongestCommonSubsequence(String text1, int index1, String text2, int index2,Map<String, Integer> longSubSequenceByIndexes) {
                    
                    if (index1 == -1 || index2 == -1) {
                        return 0;
                    }

                    if (longSubSequenceByIndexes.containsKey(index1+"*"+index2)) {
                        return longSubSequenceByIndexes.get(index1+"*"+index2);
                    }


                    if (text1.charAt(index1) == text2.charAt(index2)) {
                           return 1 + getLongestCommonSubsequence(text1, index1 - 1 , text2 , index2 - 1, longSubSequenceByIndexes);
                    }

                   int include = getLongestCommonSubsequence(text1, index1 - 1, text2 , index2, longSubSequenceByIndexes);

                   int exclude = getLongestCommonSubsequence(text1, index1 , text2 , index2 - 1, longSubSequenceByIndexes);


                    longSubSequenceByIndexes.put(index1+"*"+index2, Math.max(include, exclude));

                    return longSubSequenceByIndexes.get(index1+"*"+index2);

    }
}
