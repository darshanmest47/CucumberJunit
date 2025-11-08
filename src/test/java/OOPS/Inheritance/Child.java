package OOPS.Inheritance;

public class Child extends SingleLvel {
    public void childMethod(){
        System.out.println("Child Method");
    }

    public static void main(String[] args) {
       Child child = new Child();
       child.parentMethod();
       child.childMethod();
    }
}
