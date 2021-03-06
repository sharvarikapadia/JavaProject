/*
 * 4.28.2015
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings,
 * s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g.,"waterbottle" is a rotation of "erbottlewat").
 */

package com.ctci.C1_ArraysAndStrings;

public class Q1_8 {

    Q1_8() {

    }

    private boolean compareString(String subStr, String mainStr, int mainStrPos) {

        int subStrLen = subStr.length();
        for (int i = 0; i < subStrLen; i++) {
            if (subStr.charAt(i) != mainStr.charAt(i + mainStrPos)) {
                return false;
            }
        }
        return true;
    }

    // Checks whether str1 is substring of str2
    public boolean isSubstring(String subStr, String mainStr) {

        int subStrLen = subStr.length();
        int mainStrLen = mainStr.length();

        if (subStrLen == mainStrLen && subStrLen > 0) {
            return false;
        }

        int mainStrPos = 0;
        while (mainStrPos <= (mainStrLen - subStrLen)) {
            if (!compareString(subStr, mainStr, mainStrPos)) {
                mainStrPos++;
            } else {
                return true;
            }
        }
        return false;
    }

    // Checks if a string is rotation of another string
    public boolean isRotation(String rotatedString, String mainString) {

        if (mainString.length() != rotatedString.length()) {
            return false;
        }
        String newRotatedString;
        newRotatedString = new String(rotatedString + rotatedString);
        return isSubstring(mainString, newRotatedString);
    }

    public static void main(String[] args) {

        // test to check isSubstring
        String[][] strings = {{"var", "Sharvari"}, {"aks", "aakash"}, {"hello", "hi"}, {"erbottlewat", "waterbottle"}};
        int strLen = strings.length;
        Q1_8[] q = new Q1_8[strLen];

        for (int i = 0; i < strLen; i++) {
            q[i] = new Q1_8();
            System.out.println(q[i].isSubstring(strings[i][0], strings[i][1]));
        }

        System.out.println();

        // test to check isRotation
        String[][] strings2 = {{"erbottlewat", "waterbottle"}, {"sharvarikap", "kapadiasharvari"}};
        int str2Len = strings2.length;
        Q1_8[] q2 = new Q1_8[str2Len];

        for (int i = 0; i < str2Len; i++) {
            q2[i] = new Q1_8();
            System.out.println(q2[i].isRotation(strings2[i][0], strings2[i][1]));
        }
    }
}


