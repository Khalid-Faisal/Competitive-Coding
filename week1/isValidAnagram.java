package week1;

import java.util.Arrays;
import java.util.HashMap;

//Idea: Use of Hashmap
//Space Complexity O(N)
public class isValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("fe", "ja"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] alphaCounts = new int[26];
        Arrays.fill(alphaCounts, 0);
        for (int i = 0; i < s.length(); i++) {
            alphaCounts[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphaCounts[t.charAt(i) - 97]--;
        }
        for (int i = 0; i < alphaCounts.length; i++) {
            if (alphaCounts[i] != 0)
                return false;
        }
        return true;
    }

    public static boolean isAnagramHashLogic(String s, String t) {
        HashMap<Character, Integer> s1 = new HashMap<>();
        HashMap<Character, Integer> t1 = new HashMap<>();
        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (s1.containsKey(s.charAt(i)))
                s1.computeIfPresent(s.charAt(i), (key, value) -> value + 1);
            else
                s1.put(s.charAt(i), 1);

            if (t1.containsKey(t.charAt(i)))
                t1.computeIfPresent(t.charAt(i), (key, value) -> value + 1);
            else
                t1.put(t.charAt(i), 1);
        }
        System.out.println("MAP1 : " + s1);
        System.out.println("MAP2 : " + t1);
        if (s1.hashCode() == t1.hashCode())
            return true;
        return false;
    }
}
