public class ExceptionPropagationDemo {

    static void method1() {
        int result = 10 / 0; // ArithmeticException
    }

    static void method2() {
        method1(); // exception propagates here
    }

    public static void main(String[] args) {
        try {
            method2(); // exception propagates to main
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
