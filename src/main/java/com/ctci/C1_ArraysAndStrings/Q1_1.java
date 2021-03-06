/*
 * 4.21.2015
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data
 * structures?
 */
package com.ctci.C1_ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

public class Q1_1 {
    private String str;

    Q1_1(String str) {
        this.str = str;
    }

    // Brute force method
    public boolean areStringCharUniqueBruteForce() {

        int strLen = str.length();

        for (int i = 0; i < strLen; i++) {
            for (int j = i + 1; j < strLen; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Using Array
    public boolean areStringCharUniqueUsingArray() {

        boolean[] charArray = new boolean[256];
        int strLen = str.length();
        int currentChar;

        for (int i = 0; i < strLen; i++) {
            currentChar = (int) str.charAt(i);
            if (charArray[currentChar]) {
                return false;
            } else {
                charArray[currentChar] = true;
            }
        }
        return true;
    }

    // Using HashMap
    public boolean areStringCharUniqueUsingHashmap() {

        HashMap<Character, Boolean> hashmap = new HashMap<Character, Boolean>();
        int strLen = str.length();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < strLen; i++) {
            if (!hashmap.containsKey(charArray[i])) {
                hashmap.put(charArray[i], true);
            } else {
                return false;
            }
        }
        return true;
    }

    // Without using data structure
    public boolean areStringCharUniqueWithoutDataStructure() {

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        int charArrayLen = charArray.length;
        for (int i = 0; i < charArrayLen - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] strings = {"sharvi", "aakash"};
        int stringsLen = strings.length;
        Q1_1[] q = new Q1_1[stringsLen];

        for (int i = 0; i < stringsLen; i++) {
            q[i] = new Q1_1(strings[i]);

            System.out.println(q[i].areStringCharUniqueBruteForce());
            System.out.println(q[i].areStringCharUniqueUsingArray());
            System.out.println(q[i].areStringCharUniqueUsingHashmap());
            System.out.println(q[i].areStringCharUniqueWithoutDataStructure());
        }
    }
}
