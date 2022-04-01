package lab.demand;

import java.util.Hashtable;
import java.util.List;

public class ManageDemand {
    Hashtable<String, Double> AdditionalTaxTable = new Hashtable<String, Double>();

    private Tax tax;
    private AdditionalTax addtax;

    public ManageDemand(Tax tax, AdditionalTax addtax) {
        this.tax = tax;
        this.addtax = addtax;
    }


    public double CalculateTaxes(List<Order> orders){
        // Calculate Taxes
        double taxes = 0.0;
        for (Order order : orders) {
            double tax = this.tax.calculateTax(order.getCountry());
            taxes += tax;
        }
        return taxes;
    }

    public double calculateTotal(List<Order> orders){
        double taxes = CalculateTaxes(orders);
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
//            taxes += AdditionalTaxTable.getOrDefault(currCountry,0.0);

//
//            if (currCountry.equals("PE")) {
//                taxes += defaultAdditionalPeru;
//            } else if (currCountry.equals("BR")) {
//                taxes += defaultAdditionalBrazil;
//            } else {
//                taxes += defaultAdditionalColombia;
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
