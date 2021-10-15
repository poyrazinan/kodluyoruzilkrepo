import java.util.Arrays;
import java.util.Scanner;

public class Computer {

    private int storage, ram, discountRate, stock;
    private double screen, price, discountedPrice = -1;
    private String name;
    private Main.Brands brand;


    public Computer(String name, Main.Brands brand, int storage, int ram, double screen, double price,
                    int discountRate, int stock) {
        this.name = name;
        this.brand = brand;
        this.storage = storage;
        this.ram = ram;
        this.screen = screen;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        if (discountRate > 0)
            discountedPrice = price - (price*discountRate)/100;
    }

    public String getName() {
        return name;
    }

    public Main.Brands getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public int getRam() {
        return ram;
    }

    public double getScreen() {
        return screen;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int getStock() {
        return stock;
    }

    public double getDiscountedPrice() { return discountedPrice; }

    public static void printMenu(Main.Brands filter) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | % İndirim | Stok      | Marka     | Depolama  | Ekran     | RAM       |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        Main.computerList.stream()
                .filter(device -> (filter == null || device.getBrand().equals(filter)))
                .forEach( device -> {
                    System.out.printf("| %d  | %s | %s TL | %s | %s | %s | %s | %s | %s | ",
                    Main.computerList.indexOf(device),
                    Main.nameCompleter(device.getName(), 29),
                    (device.getDiscountedPrice() > 0) ? device.getDiscountedPrice() : device.getPrice(),
                    Main.nameCompleter(String.valueOf(device.getDiscountRate()), 9),
                    Main.nameCompleter(String.valueOf(device.getStock()), 9),
                    Main.nameCompleter(device.getBrand().name(), 9),
                    Main.nameCompleter(String.valueOf(device.getStorage()), 9),
                    Main.nameCompleter(String.valueOf(device.getScreen()), 9),
                    Main.nameCompleter(String.valueOf(device.getRam()), 9));
            System.out.println();
        });
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        Main.menuEvent(Main.MenuType.COMPUTER);
    }

    public static Computer createComputer() {
        try {
            String name;
            Main.Brands brand = null;
            int storage, ram, discountRate, stock;
            double screen, price;
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.print("Ürünün İsmini Girin: ");
            name = scanner.nextLine();
            while (brand == null) {
                System.out.print("Ürünün Markasını Girin " + Arrays.toString(Main.Brands.values()) + ": ");
                String brandName = scanner.next();
                if (Arrays.stream(Main.Brands.values()).anyMatch(brandCheck -> (brandCheck.name().equals(brandName)))) {
                    brand = Main.Brands.valueOf(brandName);
                    break;
                }
                else System.out.println("Marka bulunamadı!");
            }
            System.out.print("Ürünün Depolamasını Girin: ");
            storage = scanner.nextInt();
            System.out.print("Ürünün RAM'ini Girin: ");
            ram = scanner.nextInt();
            System.out.print("Ürünün İndirim Oranını Girin: ");
            discountRate = scanner.nextInt();
            System.out.print("Ürünün Stoğunu Girin: ");
            stock = scanner.nextInt();
            System.out.print("Ürünün Ekranını Girin: ");
            screen = scanner.nextDouble();
            System.out.print("Ürünün Fiyatını Girin: ");
            price = scanner.nextDouble();

            return new Computer(name, brand, storage, ram, screen, price, discountRate, stock);
        }
        catch (Exception e) { return null; }
    }
}
