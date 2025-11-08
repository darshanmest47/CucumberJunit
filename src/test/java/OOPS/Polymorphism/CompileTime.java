package OOPS.Polymorphism;

public class CompileTime {
    // Method overloading
    public void add(int a){
        System.out.println("sum is "+(a+0));
    }

    public void add(double a){
        System.out.println("sum is "+(a+0));
    }

    public void add(int a,int b){
        System.out.println("sum is "+(a+b));
    }

    public void add(int a, double b){
        System.out.println("sum is "+(a+b));
    }

    public void add(double a , int b){
        System.out.println("sum is "+(a+b));
    }

    public static void main(String[] args) {
        CompileTime compiltime = new CompileTime();
        compiltime.add(1);
        compiltime.add(20.5);
        compiltime.add(1,5);
        compiltime.add(2,40.5);
        compiltime.add(1.2,50);
    }
}
