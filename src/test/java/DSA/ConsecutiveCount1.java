package DSA;

public class ConsecutiveCount1 {
    public static void main(String[] args) {
        String value = "aabcccdeedbb";//a2b1c3d1e2d1b2
        conecutiveCount(value);

    }

    public static void conecutiveCount(String s){
        if(s.length()==0) System.out.println("");
        else{
            StringBuilder sb = new StringBuilder();
            int count =1;

            for(int i=1;i<=s.length()-1;i++){
                if(s.charAt(i)==s.charAt(i-1)){
                    count++;
                }else{
                    sb.append(s.charAt(i-1)).append(count);
                    count =1;
                }
            }

            sb.append(s.charAt(s.length()-1)).append(count);
            System.out.println(sb.toString());

        }
    }
}
