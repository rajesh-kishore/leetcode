class Solution {
    public List<List<Integer>> combine(int n, int k) {

       List<List<Integer>> result = new LinkedList<>();
       generateCombinations(1, n, k, new LinkedList<>(), result);

       return result;
    }


    void generateCombinations(int currentNumber, int n, int k, List<Integer> intermediateResult, List<List<Integer>> result) {
            // 4, 3  => 1,2,3  1,2,4  1,3,4  2,3,4
            // 1, 1 
            if (intermediateResult.size() == k) {
                result.add(new LinkedList<>(intermediateResult));
                return;
            }

            for (int i = currentNumber; i <= n; i++) {
                intermediateResult.add(i);
                generateCombinations(i + 1, n, k, intermediateResult, result);
                intermediateResult.removeLast();
            }
    }

}
