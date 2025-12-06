package OOPS;

import java.util.*;

public class Isomorphic {
    public static void main(String[] args) {
        String s1 = "egg", s2 = "adt";
        System.out.println(areIsomorphic(s1, s2) ? "Isomorphic" : "Non Isomorphic");
    }

    public static boolean areIsomorphic(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return false;
        else if (s1.length() != s2.length()) return false;
        else {
            Map<Character, Character> hm1 = new HashMap<>();
            Map<Character, Character> hm2 = new HashMap<>();
            boolean flag = false;
            for (int i = 0; i < s1.length(); i++) {
                if (hm1.containsKey(s1.charAt(i))) {
                    if (hm1.get(s1.charAt(i)) == s2.charAt(i)) {
                        flag = true;
                    }
                } else {
                    hm1.put(s1.charAt(i), s2.charAt(i));
                }

                if (hm2.containsKey(s2.charAt(i))) {
                    if (hm2.get(s2.charAt(i)) == s1.charAt(i)) {
                        flag = true;
                    }
                } else {
                    hm2.put(s2.charAt(i), s1.charAt(i));
                }

            }
            return flag;
        }
    }

}
