package dev.patika.kullanicigirisi;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        String userName, password, resetPassword = "hayır";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kullanıcı adı: ");
        userName = scanner.nextLine();

        System.out.print("Şifre: ");
        password = scanner.nextLine();

        if (!userName.equals("Poyraz")) {
            System.out.println("Giriş bilgileri yanlış.");
            return;
        }

        if (password.equals("deneme123"))
            System.out.println("Başarıyla giriş yaptınız.");

        else {
            System.out.print("Şifrenizi sıfırlamak istiyor musunuz? (evet, hayır) ");
            resetPassword = scanner.nextLine();
        }

        if (resetPassword.equals("evet")) {
            System.out.print("Yeni şifrenizi yazın: ");
            String newPassword = scanner.nextLine();

            System.out.println(password + " " + newPassword);

            if (newPassword.equals("deneme123") || password.equals(newPassword))
                System.out.println("Yanlış girdiğiniz veya mevcut şifreleri kullanamazsınız.");
            else
                System.out.println("Şifre başarıyla değiştirildi.");
        }

    }

}
