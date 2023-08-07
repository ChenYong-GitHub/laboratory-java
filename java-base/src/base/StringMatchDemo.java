package base;

import java.util.HashMap;
import java.util.Map;

public class StringMatchDemo {

    public static void main(String[] args) {
        String a = "abcdefg"; // Replace with your string a
        String b = "abc";     // Replace with your string b

        // Initialize a map to store the frequency of matched substrings
        Map<String, Integer> matchedSubstrings = new HashMap<>();

        // Split string a into individual characters
        for (int i = 0; i < a.length(); i++) {
            String singleChar = Character.toString(a.charAt(i));
            updateMatchedSubstrings(matchedSubstrings, singleChar, b);
        }

        // Split string a into substrings of length 2, 3, 4, etc.
        for (int length = 2; length <= a.length(); length++) {
            for (int i = 0; i <= a.length() - length; i++) {
                String substring = a.substring(i, i + length);
                updateMatchedSubstrings(matchedSubstrings, substring, b);
            }
        }

        // Print the matched substrings and their frequencies
        for (Map.Entry<String, Integer> entry : matchedSubstrings.entrySet()) {
            System.out.println("Substring: " + entry.getKey() + ", Frequency: " + entry.getValue());
        }
    }

    private static void updateMatchedSubstrings(Map<String, Integer> map, String substring, String b) {
        if (b.contains(substring)) {
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            // Check if the matched substring contains shorter substrings and update their frequencies
            for (int i = 1; i < substring.length(); i++) {
                String shorterSubstring = substring.substring(0, i);
                map.put(shorterSubstring, map.getOrDefault(shorterSubstring, 0) + 1);
            }
        } else {
            // If substring does not match, add it to the map with frequency 0
            map.put(substring, map.getOrDefault(substring, 0));
        }
    }
}
