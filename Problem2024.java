class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        int maxConsequitiveTrues = 0;
        int currentSlidingWindowStartIndex = 0;

        int totalRepalced = 0;
            //11000011
        for (int i = 0 ; i < answerKey.length() ;i++) {

            if (answerKey.charAt(i) == 'F') {
                totalRepalced++;
            }

            while (totalRepalced > k && currentSlidingWindowStartIndex <= i) {
                    if (answerKey.charAt(currentSlidingWindowStartIndex) == 'F') {

                            totalRepalced--;
                    }
                     currentSlidingWindowStartIndex++;

            }

            maxConsequitiveTrues = Math.max(maxConsequitiveTrues, i - currentSlidingWindowStartIndex + 1);
        }

        // now against ''T
        totalRepalced = 0;
        int maxConsequitiveFalses = 0;
        currentSlidingWindowStartIndex = 0;

        for (int i = 0 ; i < answerKey.length() ;i++) {

      

            if (answerKey.charAt(i) == 'T') {
                //totalRepalced.put('F' , totalRepalced.getOrDefault('F', 0) + 1);
                totalRepalced++;
            }

            while (totalRepalced > k && currentSlidingWindowStartIndex <= i) {
                    if (answerKey.charAt(currentSlidingWindowStartIndex) == 'T') {

                            totalRepalced--;
                    }
                     currentSlidingWindowStartIndex++;

            }
           

            maxConsequitiveFalses = Math.max(maxConsequitiveFalses, i - currentSlidingWindowStartIndex + 1);

        }


        return Math.max(maxConsequitiveFalses, maxConsequitiveTrues);
    }
}
