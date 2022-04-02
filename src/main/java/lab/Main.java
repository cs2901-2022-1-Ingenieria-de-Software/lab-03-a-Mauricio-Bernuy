package lab;

import lab.demand.AdditionalTax;
import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.demand.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main (String [ ] args) {
        logger.log(Level.INFO, "===INICIO====");

        Tax tax = new Tax();
        AdditionalTax addtax = new AdditionalTax();

        // add additional taxes
        addtax.addTax("CO", 0.10);
        addtax.addTax("PE", 0.20);
        addtax.addTax("BR", 0.30);
        addtax.setDefaultCountry("CO");
        
        ManageDemand mg = new ManageDemand(tax, addtax);

        List<Order> testOrders = buildSampleOrders();
        
        double resultFirst = mg.calculateTotal(testOrders);
        logger.log(Level.INFO, String.format("RESULTADO TOTAL 1 => %s", resultFirst));

        double resultSecond = mg.calculateTotalForWithAdditionalByCountry(testOrders);
        logger.log(Level.INFO, String.format("RESULTADO TOTAL 2 => %s", resultSecond));
    }

    private static List<Order> buildSampleOrders() {
        List<Order> testOrders = new ArrayList<>();
        testOrders.add(new Order("PE", 10L));
        testOrders.add(new Order("PE", 20L));
        testOrders.add(new Order("CO", 10L));
        testOrders.add(new Order("BR", 10L));
        return testOrders;
    }

}
