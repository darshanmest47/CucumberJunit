package OOPS;

public class PalindromeString {
    public static void main(String[] args) {
        String  s = "  ";
        System.out.println(isAPalindrome(s.trim())?"String is Palindrome":"String is not a palindrome");

    }

    public static boolean isAPalindrome(String s){
        if(s.isEmpty()) return false;
        else{
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            String replaced = s.replaceAll("[^0-9A-Za-z]","").toLowerCase();
            for(int i=replaced.length()-1;i>=0;i--){
                sb.append(replaced.charAt(i));
            }
            System.out.println("Reversed value is "+sb.toString());
            System.out.println("Replaced string is "+replaced);

            if(sb.toString().equals(replaced)){
                flag = true;
            }else{
                flag = false;
            }
            return flag;

        }
    }
}
