import java.util.Scanner;

public class MobilePhone extends Computer {

    private float battery;
    private int camera;
    private String color;

    public MobilePhone(String name, Main.Brands brand, int storage,
                       int ram, double screen, double price, float battery, int camera, String color,
                       int discountRate, int stock) {
        super(name, brand, storage, ram, screen, price, discountRate, stock);
        this.battery = battery;
        this.camera = camera;
        this.color = color;
    }

    public float getBattery() {
        return battery;
    }

    public String getColor() {
        return color;
    }

    public int getCamera() {
        return camera;
    }

    public static void printMenu(Main.Brands filter) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | % İndirim | Stok      | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Main.mobilePhoneList.stream()
                .filter(device -> (filter == null || device.getBrand().equals(filter)))
                .forEach( device -> {
                    System.out.printf("| %d  | %s | %s TL | %s | %s | %s | %s | %s | %s | %s | %s | %s | ",
                    Main.mobilePhoneList.indexOf(device),
                    Main.nameCompleter(device.getName(), 29),
                    (device.getDiscountedPrice() > 0) ? device.getDiscountedPrice() : device.getPrice(),
                    Main.nameCompleter(String.valueOf(device.getDiscountRate()), 9),
                    Main.nameCompleter(String.valueOf(device.getStock()), 9),
                    Main.nameCompleter(device.getBrand().name(), 9),
                    Main.nameCompleter(String.valueOf(device.getStorage()), 9),
                    Main.nameCompleter(String.valueOf(device.getScreen()), 9),
                    Main.nameCompleter(String.valueOf(device.getCamera()), 9),
                    Main.nameCompleter(String.valueOf(device.getBattery()), 9),
                    Main.nameCompleter(String.valueOf(device.getRam()), 9),
                    Main.nameCompleter(device.getColor(), 9));
            System.out.println();
        });
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");

        Main.menuEvent(Main.MenuType.PHONE);
    }

    public static MobilePhone createPhone() {
        try {
            Computer computer = Computer.createComputer();
            float battery;
            int camera;
            String color;

            System.out.print("Ürünün Baterisini Girin: ");
            battery = Main.scanner.nextFloat();
            System.out.print("Ürünün Rengini Girin: ");
            color = Main.scanner.next();
            System.out.print("Ürünün Kamerasını Girin: ");
            camera = Main.scanner.nextInt();
            MobilePhone phone = new MobilePhone(computer.getName(), computer.getBrand(),
                    computer.getStorage(), computer.getRam(), computer.getScreen(), computer.getPrice(),
                    battery, camera, color, computer.getDiscountRate(), computer.getStock());
            return phone;
        }
        catch (Exception e) { return null; }
    }
}
