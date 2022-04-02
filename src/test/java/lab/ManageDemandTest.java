package lab;

import lab.demand.AdditionalTax;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.util.TestUtil;
import lab.demand.Order;

import java.util.List;

@Test
public class ManageDemandTest {

    private Tax tax;
    private AdditionalTax addTax;
    private ManageDemand demand;

    @BeforeClass
    public void setup() {
        tax = new Tax();
        addTax = new AdditionalTax();

        // add additional taxes
        addTax.addTax("CO", 0.10);
        addTax.addTax("PE", 0.20);
        addTax.addTax("BR", 0.30);
        addTax.setDefaultcountry("CO");

        demand = new ManageDemand(tax, addTax);
    }

    // Tax related tests

    // Present tax values in dictionary

    public void test_AllOrdersFromPeru() {
        setup();
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotal(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 7.0);
    }
    public void test_AllOrdersFromBrazil() {
        setup();
        List<Order> ordersfromBrazil= TestUtil.buildOrdersBrazil();
        double result = demand.calculateTotal(ordersfromBrazil);
        Assert.assertEquals(Math.round(result), 5.0);
    }

    // Missing tax values from dictionary

    public void test_AllOrdersFromColombia() {
        setup();
        List<Order> ordersfromColombia= TestUtil.buildOrdersColombia();
        double result = demand.calculateTotal(ordersfromColombia);
        Assert.assertEquals(Math.round(result), 0.0);
    }

    public void test_AllOrdersFromArgentina() {
        setup();
        List<Order> ordersfromArgentina= TestUtil.buildOrdersArgentina();
        double result = demand.calculateTotal(ordersfromArgentina);
        Assert.assertEquals(Math.round(result), 0.0);
    }

    // AdditionalTax related tests

    // Present tax values in dictionary

    public void test_AdditionalAdditionalOrdersFromPeru() {
        setup();
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 8.0);
    }
    public void test_AdditionalAllOrdersFromBrazil() {
        setup();
        List<Order> ordersfromBrazil= TestUtil.buildOrdersBrazil();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersfromBrazil);
        Assert.assertEquals(Math.round(result), 12.0);
    }
    public void test_AdditionalAllOrdersFromColombia() {
        setup();
        List<Order> ordersfromColombia= TestUtil.buildOrdersColombia();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersfromColombia);
        Assert.assertEquals(Math.round(result), 4.0);
    }

    // Missing tax values from dictionary (default value: CO)

    public void test_AdditionalAllOrdersFromArgentina() {
        setup();
        List<Order> ordersfromArgentina= TestUtil.buildOrdersArgentina();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersfromArgentina);
        Assert.assertEquals(Math.round(result), 4.0);
    }

    // Add Tests !!

}
