package probs.string;

import java.util.HashMap;
import java.util.Map;

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

    public static int maxVowels(String s, int k) {
        int maxVowelLength = 0, windowVowelLength = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if(checkVowelLetter(chars[i])){
                windowVowelLength++;
            }
        }
        maxVowelLength = windowVowelLength;

        for (int i = k; i < chars.length; i++) {
            if(checkVowelLetter(chars[i - k])){
                windowVowelLength --;
            }
            if(checkVowelLetter(chars[i])){
                windowVowelLength ++;
            }
            maxVowelLength = Math.max(maxVowelLength, windowVowelLength);
        }

        return maxVowelLength;
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < word1.length() + word2.length(); i++) {
            if(i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }

    public String removeStars(String s) {
        while(s.contains("*")) {
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '*') {
                    s = s.substring(0, i) + s.substring(i + 1);
                    break;
                }
            }
        }
        return s;
    }

    private static boolean checkVowelLetter(Character c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
