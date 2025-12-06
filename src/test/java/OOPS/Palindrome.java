package OOPS;

public class Palindrome {

    public static void main(String[] args) {

        int num = 1221;
        int temp = num;
        int num2 =0;

        while(num!=0){
            System.out.println(num%10);
            num2= (num2*10 + (num%10));
            num = num/10;
        }

        if(num2==temp) System.out.println("Palindrome");
        else{
            System.out.println("Not a palindrome");
        }

    }

}
