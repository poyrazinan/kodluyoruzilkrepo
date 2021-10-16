import exceptions.InvalidAuthenticationException;
import objects.Account;

import java.util.TreeSet;

public class AccountManager {

    public static TreeSet<Account> accounts = new TreeSet<>();

    public static boolean login(InputReaderManager reader) {
        Account account = accounts.stream()
                .filter(accountRaw -> (
                        accountRaw.getUser().getEmail().equalsIgnoreCase(reader.getEmail())  ||
                        accountRaw.getUser().getPassword().equalsIgnoreCase(reader.getPassword())  ))
                .findFirst().orElseGet(null);

        if (account == null)
            return false;

        else {
            try {
                account.login(reader.getEmail(), reader.getPassword());
                return true;
            } catch (InvalidAuthenticationException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

}
