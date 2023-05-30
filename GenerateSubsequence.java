import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateSubsequence {

    private static void generateSubSequence(String s, int startIndex, Deque<String> intermediateResult, List<List<String>> results) {


        if (startIndex == s.length()) {
            results.add(new LinkedList<>(intermediateResult));
            return;
        }

        char c = s.charAt(startIndex);

        // include
        intermediateResult.offerLast("" + c);
        generateSubSequence(s, startIndex + 1, intermediateResult, results);

        // exclude
        intermediateResult.removeLast();
        generateSubSequence(s, startIndex + 1, intermediateResult, results);

    }

    public static void main(String[] args) {
        List<List<String>> results = new LinkedList<>();

        generateSubSequence("abc", 0, new LinkedList<>(), results);
        System.out.println(results);
    }
}

