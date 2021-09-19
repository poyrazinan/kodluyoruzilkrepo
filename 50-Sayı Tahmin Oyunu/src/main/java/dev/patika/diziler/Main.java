package dev.patika.diziler;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int random = new Random().nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int[] wrongs = new int[5];
        boolean isWin = false, hasWrongInput = false;

        for (int right = 5; right > 0; right--) {
            System.out.print("Tahminde bulunun: ");
            int selected = scanner.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Lütfen 0 ile 99 arasında bir sayı girin.");
                if (!hasWrongInput) {
                    System.out.println("Bir daha hatalı giriş yaparsanız hakkınızdan eksilecek.");
                    hasWrongInput = true;
                    right++;
                }
                else
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak: " + (right-1));

                continue;
            }

            if (selected == random) {
                System.out.println("Sayıyı doğru bildiniz! Sayı: " + selected);
                isWin = true;
                break;
            }
            else {
                System.out.println("Hatalı bir sayı girdiniz.");
                if (selected > random)
                    System.out.println("Tuttuğum sayı senin söylediğinden KÜÇÜK.");
                else
                    System.out.println("Tuttuğum sayı senin tuttuğundan BÜYÜK.");
                wrongs[right-1] = selected;
                System.out.println("Kalan hak: " + (right-1));
            }
        }

        if (!isWin) {
            System.out.println("Kaybettiniz sayı: " + random);
            if (!hasWrongInput)
                System.out.println("Tahminleriniz: " + Arrays.toString(wrongs));
        }
    }
}
