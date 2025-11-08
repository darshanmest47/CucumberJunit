package OOPS.Polymorphism;

public class Composition {
    // has-a relationship  one class will hold another class object as it's state to avoid inheritance

    private static class First{
        int x = 30;

        public void methodM(){
            System.out.println("Value of x from parent is "+x);
        }
    }

    private static class Second{
        First first;

        public Second(){
            first = new First();
        }
        int x = 20;

        public void methodM(){
            System.out.println("Value of x is "+x);
            System.out.println("Value of x from parent is "+first.x);
            first.methodM();
        }
    }

    public static void main(String[] args) {
        Second second =  new Second();
        System.out.println(second.x);
        second.methodM();
    }
}
