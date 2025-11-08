package DSA;

public class CommonPrefix {
    public static void main(String[] args) {
        String arr[] = {"flower","flaws","flame","flow"};
        System.out.println(commonPrefix(arr));
    }

    public static String commonPrefix(String[] s){
        if(s.length==0) return "";
        else if(s.length==1) return s[0];
        else{
            String prefix = s[0];
            
            for(int i=1;i<s.length;i++){
                while(s[i].indexOf(prefix)!=0){
                    prefix = prefix.substring(0,prefix.length()-1);
                }
            }
             return prefix.length()==0?"No longest common prefix exists":prefix;
        }
       
    }

}
