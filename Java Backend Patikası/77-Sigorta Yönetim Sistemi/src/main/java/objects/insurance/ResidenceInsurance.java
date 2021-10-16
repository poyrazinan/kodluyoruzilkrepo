package objects.insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance {

    public ResidenceInsurance(String insuranceName, double price, Date startDate, Date finishDate) {
        super(insuranceName, price, startDate, finishDate);
    }

    @Override
    public void calculate() {

    }
}
