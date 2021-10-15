import java.util.*;

class Main {

    public static List<String> brands = new ArrayList<>();
    public enum Brands {
                Samsung,
                Lenovo,
                Apple,
                Huawei,
                Casper,
                Asus,
                HP,
                Xiaomi,
                Monster
    }
    public enum MenuType {
        COMPUTER,
        PHONE
    }
    public static List<Computer> computerList = new ArrayList<>();
    public static List<MobilePhone> mobilePhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        // Adding brands to list
        for (Brands key : Brands.values())
            brands.add(key.name());
        // Sorting list
        brands.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // Template products register
        mobilePhoneList.add(new MobilePhone("test", Brands.Monster, 32, 32, 15.2, 1500.0,
                3600, 11, "Siyah", 25, 100)
        );
        computerList.add(new Computer("test", Brands.Monster, 32, 32, 15.2, 1500.0,
                3600, 11)
        );

        // Menü
        while (true) {
            System.out.println();
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            int selection = scanner.nextInt();

            if (selection == 0)
                break;

            else if (selection == 1) {
                System.out.println();
                Computer.printMenu(null);
            }

            else if (selection == 2) {
                System.out.println();
                MobilePhone.printMenu(null);
            }

            else if (selection == 3) {
                System.out.println();
                printBrands();
            }
        }

    }

    private static void printBrands() {
        System.out.println("Markalarımız: ");
        for (String brand : brands) {
            System.out.println("- " + brand);
        }
    }

    // Name = 29
    // Others = 9
    public static String nameCompleter(String text, int size) {
        if (text.length() > size-1)
            return text.substring(0, size-1);

        int blankCount = size-text.length();
        for (int i = 0; i < blankCount; i++)
            text += " ";
        return text;
    }

    public static void menuEvent(MenuType type) {
        int selection = 0;
        while (selection == 0) {
            System.out.println("1) Filtrele");
            System.out.println("2) Ürün Ekle");
            System.out.println("3) Ürün Sil");
            System.out.println("4) Ana Menü");
            System.out.print("İşlem seçin: ");
            selection = scanner.nextInt();

            if (selection < 1 || selection > 4) {
                selection = 0;
                System.out.println("Hatalı bir giriş yaptınız !");
            }
        }

        switch (selection) {
            case 1:
                filterMenu(type);
                break;
            case 2:
                addProduct(type);
                break;
            case 3:
                removeProduct(type);
                break;
            case 4:
                break;
        }

    }

    private static void filterMenu(MenuType type) {
        Brands brand = null;
        System.out.println();
        while (brand == null) {
            System.out.print("Markayı girin: ");
            String brandName = scanner.next();
            if (Arrays.stream(Brands.values()).anyMatch(brandBase -> (brandBase.name().equals(brandName))))
                brand = Brands.valueOf(brandName);
            else {
                System.out.println("Hatalı bir marka girdiniz!");
                printBrands();
            }
        }
        if (type.equals(MenuType.COMPUTER))
            Computer.printMenu(brand);
        else
            MobilePhone.printMenu(brand);
    }

    private static void addProduct(MenuType type) {
        boolean status = type.equals(MenuType.COMPUTER) ? computerList.add(Computer.createComputer())
                : mobilePhoneList.add(MobilePhone.createPhone());

        if (type.equals(MenuType.COMPUTER))
            Computer.printMenu(null);
        else
            MobilePhone.printMenu(null);
    }

    private static void removeProduct(MenuType type) {
        int selection;
        System.out.print("Lütfen silinecek ID'yi girin: ");
        selection = scanner.nextInt();
        if (type.equals(MenuType.COMPUTER)) {
            if (computerList.size() > selection)
                computerList.remove(selection);
        }
        else {
            if (mobilePhoneList.size() > selection)
                mobilePhoneList.remove(selection);
        }

        if (type.equals(MenuType.COMPUTER))
            Computer.printMenu(null);
        else
            MobilePhone.printMenu(null);
    }

}
