package DSA;
import java.util.*;

public class RomanToIntger {
    public static void main(String[] args) {
        Map<Character,Integer> hm = new LinkedHashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        //String s = "LVIII"; //58
        //String s = "MCMXCIV"; //1994
        String s = "III"; //3

     romanToInteger(s, hm);
    }

    public static void romanToInteger(String s,Map<Character,Integer>hm){
     if(s.length()==0) System.out.println("");
     else{
        int sum =0;
        for(int i=1;i<=s.length()-1;i++){
          if(hm.get(s.charAt(i))<= hm.get(s.charAt(i-1))){
            sum+= hm.get(s.charAt(i-1));
          }else{
            sum-=hm.get(s.charAt(i-1));
          }
        }
        System.out.println(sum+ hm.get(s.charAt(s.length()-1)));
     }
    }

}
