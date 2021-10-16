package objects.adress;

public class BusinessAddress implements Address {

    private String address;

    public BusinessAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return null;
    }
}
