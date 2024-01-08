class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
       List<List<Integer>> result = new LinkedList<>();
        generateCombinations(9, k, 1, 0, new LinkedList<>(), n, result);

       return result;
    }


    void generateCombinations(int maxNumber, int kCombination, int currentNumber, int sumSoFar, List<Integer> intermediateResult, int target, List<List<Integer>> result) {
            // k =3 , n = 7
            if (intermediateResult.size() == kCombination && sumSoFar == target) {
                  List<Integer> rs = new LinkedList<>(intermediateResult);
                  result.add(rs);

                return;
            }

            for (int i = currentNumber; i <= maxNumber; i++) {
                if (sumSoFar +  i > target) {
                    return;// since array is already sorted
                }
                
                intermediateResult.add(i);
                generateCombinations(maxNumber, kCombination, i + 1, sumSoFar + i, intermediateResult, target, result);
                intermediateResult.removeLast();
            }

    }
}
