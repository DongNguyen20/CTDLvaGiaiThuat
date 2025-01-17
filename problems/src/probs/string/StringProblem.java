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

    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }

    public static String countAndSay(int n) {
        String prev = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == prev.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(prev.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count).append(prev.charAt(prev.length() - 1));
            prev = sb.toString();
        }
        return prev;
    }
}
