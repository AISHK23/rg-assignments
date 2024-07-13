package java8;

@FunctionalInterface
interface Calculation {
    int operation(int a, int b);
}


public class LambdaExample {
    public static void main(String[] args) {
        Calculation addition = (a, b) -> a + b;
        Calculation multiplication = (a, b) -> a * b;

        System.out.println("Addition result: " + addition.operation(1, 2));
        System.out.println("Multiplication result: " + multiplication.operation(1, 2));
    }
}
