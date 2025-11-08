package OOPS.Polymorphism;

public class RunTime {
    // Method overriding with is-a relationship
    private static class First {
        int x = 10;

        public void methodM() {
            System.out.println("First Method");
        }
    }

    private static class Second extends First {
        int x = 20;

        @Override
        public void methodM() {
            System.out.println("Second Method");
        }
    }

    public static void main(String[] args) {
       First second =  new Second(); // methods are resolved at run time based on object type
       second.methodM();
        System.out.println(second.x);

    }
}
