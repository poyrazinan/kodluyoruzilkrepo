package objects;

import exceptions.InvalidAuthenticationException;
import objects.account.AuthenticationStatus;
import objects.account.User;
import objects.adress.Address;
import objects.insurance.Insurance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Comparable<Account> {

    private AuthenticationStatus authStatus = AuthenticationStatus.FAIL;
    private User user;
    private List<Insurance> insuranceList = new ArrayList<>();

    public abstract boolean addInsurance(Insurance insurance);

    public Account(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password))
            authStatus = AuthenticationStatus.SUCCESS;
        else throw new InvalidAuthenticationException("Incorrect email or password");
    }

    public final void showUserInfo() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm dd/MM/yyy");
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Job: " + user.getJob());
        System.out.println("Age: " + user.getAge());
        System.out.println("Last Login: " + format.format(user.getLastLogin()));
        System.out.println("Addresses: ");
        user.getAddressList().stream().forEach(address -> {
            System.out.println(address.getAddress());
        });
    }

    public void addAddress(Address address) {
        user.getAddressList().add(address);
    }

    public boolean removeAddress(Address address) {
        return user.getAddressList().remove(address);
    }

}
