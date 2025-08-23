package DSA;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String value1 = "foo", value2 = "add";
        System.out.println(areIsomorphicStrings(value1, value2)?"Isomorphic":"Not Isomorphic");
    }

    public static boolean areIsomorphicStrings(String value1, String value2) {
        if (value1.length() != value2.length()) {
            return false;
        } else {
            Map<Character, Character> hm1 = new HashMap<>();
            Map<Character, Character> hm2 = new HashMap<>();
            for (int i = 0; i < value1.length(); i++) {
                if (hm1.containsKey(value1.charAt(i))) {
                    if (hm1.get(value1.charAt(i)) != value2.charAt(i)) {
                        return false;
                    }
                } else {
                    hm1.put(value1.charAt(i), value2.charAt(i));
                }

                if (hm2.containsKey(value2.charAt(i))) {
                    if (hm2.get(value2.charAt(i)) != value1.charAt(i)) {
                        return false;
                    }
                } else {
                    hm2.put(value2.charAt(i), value1.charAt(i));
                }
            }
            return true;
        }
    }
}
