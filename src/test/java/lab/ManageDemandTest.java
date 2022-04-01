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
    private AdditionalTax addtax;
    private ManageDemand demand;

    @BeforeClass
    public void setup() {
        tax = new Tax();
        addtax = new AdditionalTax();
        demand =  new ManageDemand(tax,addtax);
    }
    
    public void test_AllOrdersFromPeru() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotal(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 7.0);
    }

    // Add Tests !!

}
