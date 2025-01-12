package probs.string;

public class StringProblem {
    StringProblem(){}

    public static boolean isPalindrome(int x) {
        int midIndex = String.valueOf(x).length()/2;
        for (int i = 0; i < midIndex; i++) {
            if (String.valueOf(x).charAt(i) != String.valueOf(x).charAt(String.valueOf(x).length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
