import java.util.Scanner;

public class InputReaderManager {

    private String email, password;

    public InputReaderManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Eposta Girin: ");
        this.email = scanner.next();
        System.out.print("Şifre Girin: ");
        this.password = scanner.next();
        AccountManager.login(this);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
