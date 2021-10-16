package objects.account;

import objects.adress.Address;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private String first_name, last_name, email, password, job;
    private int age;
    private List<Address> addressList = new ArrayList<>();
    private Date lastLogin;

    public User(String first_name, String last_name, String email, String password, String job, int age, List<Address> addressList, Date lastLogin) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.addressList = addressList;
        this.lastLogin = lastLogin;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
