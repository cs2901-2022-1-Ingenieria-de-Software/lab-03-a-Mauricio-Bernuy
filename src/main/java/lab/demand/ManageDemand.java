package lab.demand;

import java.util.HashMap;
import java.util.List;

public class ManageDemand {

    private Tax tax;
    private AdditionalTax addtax;

    public ManageDemand(Tax tax, AdditionalTax addtax) {
        this.tax = tax;
        this.addtax = addtax;
    }

    public double calculateTaxes(List<Order> orders){
        // Calculate Taxes
        double taxes = 0.0;
        for (Order order : orders) {
            double taxCount = this.tax.calculateTax(order.getCountry());
            taxes += taxCount;
        }
        return taxes;
    }

    public double calculateTotal(List<Order> orders){
        double taxes = calculateTaxes(orders);
        // Calculate Total
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }

        return quantities * taxes;
    }

    public double calculateAdditionalByCountry(List<Order> orders){
        // Calculate additionals by country
        double taxes = 0.0;
        for (Order order : orders) {
            String currCountry = order.getCountry();
            taxes += this.addtax.calculateTax(currCountry);
        }
        return taxes;
    }
    public double calculateTotalForWithAdditionalByCountry(List<Order> orders){
        double taxes = calculateAdditionalByCountry(orders);
        // Calculate Total
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }

        return quantities * taxes;
    }

}
