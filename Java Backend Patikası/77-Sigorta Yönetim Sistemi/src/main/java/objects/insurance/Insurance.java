package objects.insurance;

import java.util.Date;

public abstract class Insurance {

    private String insuranceName;
    private double price;
    private Date startDate, finishDate;

    protected Insurance(String insuranceName, double price, Date startDate, Date finishDate) {
        this.insuranceName = insuranceName;
        this.price = price;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public abstract void calculate();

}
