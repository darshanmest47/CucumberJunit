package OOPS;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[]vals = {4,2,4,5,2,3,1,5};

        int n = vals.length;
        int[] temp = new int[n];
        int k= 0;
        for(int i=0;i<n;i++){
            boolean isDuplicate = false;

            for(int j=0;j<k;j++){
                if(vals[i]==temp[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){

                temp[k]=vals[i];
                k++;
            }
        }

        for(int i=0;i<k;i++){
            System.out.println(temp[i]);
        }
    }
}
