/*
  * 4.25.2015
  * Implement a method to perform basic string compression using the counts of repeated characters. For example, the
  * string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original
  * string, your method should return the original string.
  */

package com.ctci.C1_ArraysAndStrings;

public class Q1_5 {

    public String getCompressedString(String str) {

        int strLen = str.length();
        char[] charArray = str.toCharArray();
        char[] newCharArray = new char[strLen * 2];
        byte count = 0;
        char currChar;
        int i = 0, j = 0;

        // Generate new compressed string in form of char array
        while (i < strLen) {
            currChar = charArray[i];
            while (charArray[i] == currChar) {
                count++;
                i++;

                if (i >= strLen) {
                    break;
                }
            }
            newCharArray[j] = currChar;
            newCharArray[j + 1] = Byte.toString(count).charAt(0);
            j += 2;
            count = 0;
        }

        // Return newly generated string or the original string based on their lengths
        int newLen = j;
        if (newLen < strLen) {
            String newStr = new String(newCharArray);
            return newStr.trim();
        } else {
            return new String(charArray);
        }
    }

    public static void main(String[] args) {

        String[] strings = {"aabccccaa", "abcd", "aabbccaa"};
        int stringsLen = strings.length;
        Q1_5[] q = new Q1_5[stringsLen];

        for (int i = 0; i < stringsLen; i++) {
            q[i] = new Q1_5();

            System.out.println("Original string: " + strings[i]);
            System.out.println("Compressed string: " + q[i].getCompressedString(strings[i]));
            System.out.println();
        }
    }
}
