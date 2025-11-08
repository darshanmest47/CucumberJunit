package OOPS.Inheritance;

public class MultiLevel extends Child {

    public void multiMethod(){
        System.out.println("Method from multilevel");
    }

    public static void main(String[] args) {
       MultiLevel multilevel =  new MultiLevel();
       multilevel.parentMethod();
       multilevel.childMethod();
       multilevel.multiMethod();
    }
}
