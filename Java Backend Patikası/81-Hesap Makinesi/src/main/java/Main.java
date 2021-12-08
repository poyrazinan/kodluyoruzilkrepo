import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Toplama");
        System.out.println("2) Çıkarma");
        System.out.println("3) Bölme");
        System.out.println("4) Çarpma");
        System.out.println("5) Üs Alma");
        System.out.println("6) Karekök Alma");
        System.out.println("7) Faktöriyel Hesaplama");
        System.out.println("8) Mod Alma");
        System.out.println("9) Mutlak Değer");
        System.out.print("Lütfen işlemi seçin: ");
        int selection = 0;
        while (selection < 1 || selection > 9) {
            try {
                selection = scanner.nextInt();
            }
            catch (Exception e) {
                System.out.println("Lütfen sayı giriniz.");
            }
        }

        Calculate calc = null;
        switch (selection) {
            case 1:
                calc = new Sum();
                break;
            case 2:
                calc = new Negate();
                break;
            case 3:
                calc = new Divide();
                break;
            case 4:
                calc = new Multiple();
                break;
            case 5:
                calc = new Expo();
                break;
            case 6:
                calc = new Root();
                break;
            case 7:
                calc = new Factorial();
                break;
            case 8:
                calc = new Mod();
                break;
            case 9:
                calc = new Absolute();
                break;
            default:break;
        }

        int num1, num2;
        System.out.print("İlk sayıyı girin: ");
        if (calc.requireOneInput) {
            num1 = scanner.nextInt();
            calc.calc(num1);
        }
        else {
            num1 = scanner.nextInt();
            System.out.print("İkinci sayıyı girin: ");
            num2 = scanner.nextInt();
            calc.calc(num1, num2);
        }

    }
}
