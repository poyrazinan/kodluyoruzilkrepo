package dev.patika.donguler;

public class Main {

    public static void main(String... args) {
        for (int number = 1; number <= 100; number++) {
            boolean isNotPrime = false;
            for (int i = 2; i <= number/2 ; ++i) {
                if (number % i == 0) {
                    isNotPrime = true;
                    break;
                }
            }
            if (!isNotPrime)
                System.out.print(number + " ");
        }
    }
}
