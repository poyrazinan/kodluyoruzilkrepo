package objects.insurance;

import java.util.Date;

public class CarInsurance extends Insurance {

    public CarInsurance(String insuranceName, double price, Date startDate, Date finishDate) {
        super(insuranceName, price, startDate, finishDate);
    }

    @Override
    public void calculate() {

    }
}
