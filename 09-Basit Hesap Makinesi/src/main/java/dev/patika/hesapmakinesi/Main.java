package dev.patika.hesapmakinesi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {

        int firstInput, secondInput;
        char operator;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Hesap operatörünü giriniz (*, /, +, -, %): ");
            operator = scanner.nextLine().charAt(0);

            System.out.print("İlk sayıyı girin: ");
            firstInput = scanner.nextInt();

            System.out.print("İkinci sayıyı girin: ");
            secondInput = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Hatalı bir şey girdiniz. Lütfen programı tekrar başlatın.");
            return;
        }

        int result;
        switch (operator) {
            case '*':
                result = firstInput*secondInput;
                break;
            case '-':
                result = firstInput-secondInput;
                break;
            case '/':
                result = firstInput/secondInput;
                break;
            case '%':
                result = (firstInput * secondInput) / 100;
                break;
            default:
                result = firstInput+secondInput;
                break;
        }

        System.out.println("Formül: (" + firstInput + " " + operator + " " + secondInput + ") " +
                "\nSonuç: " + result );
    }

}
