package DSA;

public class ConsecutiveCharCount {
    public static void main(String[] args) {
        String value = "aabccddeeb";
        System.out.println(getConsecutiveCharCount(value));
    }

    public static String getConsecutiveCharCount(String value) {
        if (value.length() == 0) return "";
        else {
            StringBuilder sb = new StringBuilder();
            int i = 1, count = 1;
            while (i < value.length()) {
                if (value.charAt(i) == value.charAt(i - 1)) {
                    count++;
                    i++;
                } else {
                    sb.append(value.charAt(i-1)).append(count);
                    i++;
                    count = 1;
                }
            }
            sb.append(value.charAt(value.length()-1)).append(count);
            return sb.toString();
        }
    }
}
