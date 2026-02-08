package org.example.leetcode;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int currentMax = 0;
        int totalMax = 0;
        int words = 0;
        boolean isComming = false;

        for (int i = chars.length - 1; i >= 0; i--) {
            char currentChar = chars[i];
            boolean isLetter = Character.isLetter(currentChar);

            if (isLetter) {
                if (!isComming) {
                    words++;
                }

                isComming = true;

                if (words > 1) {
                    break;
                }

                currentMax++;
            }

            if (!isLetter) {
                isComming = false;
                totalMax = Math.max(totalMax, currentMax);
            }
        }

        return Math.max(totalMax, currentMax);
    }

    public int lengthOfLastWordWithInbuildMethod(String s) {
        String[] cur = s.split(" ");
        return cur[cur.length - 1].length();
    }
}