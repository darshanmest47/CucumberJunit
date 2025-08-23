package DSA;

import java.util.*;

public class ReverseWithSpace {
    public static void main(String[] args) {
        String value = "abc de";
        System.out.println(reverseWithSpace(value));
    }

    public static String reverseWithSpace(String value) {
        if (value.length() == 0) return "";
        else {
            StringBuilder sb = new StringBuilder();
            List<Integer> al = new ArrayList<>();
            for (int i = value.length()-1; i >=0; i--) {
                if (value.charAt(i) == ' ') {
                    al.add(i);
                }else{
                    sb.append(value.charAt(i));
                }
            }
            for(int i=0;i<al.size();i++){
                sb.insert(al.get(i)," ");
            }
            return sb.toString();
        }
    }
}
