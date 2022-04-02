package lab;

import lab.demand.AdditionalTax;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import lab.demand.Tax;

@Test
public class TaxTest {

    private Tax tax;
    private AdditionalTax addtax;

    @BeforeClass
    public void setup() {
        tax = new Tax();
        addtax = new AdditionalTax();
    }

    // Tax
    // add one entry, three resulting
    public void tax_tests_1(){
        setup();
        tax.addTax("CO", 0.10);
        Assert.assertEquals(tax.size(), 3);
    }

    // add three entries, two already in dictionary
    public void tax_tests_2(){
        setup();
        tax.addTax("CO", 0.10);
        tax.addTax("PE", 0.20);
        tax.addTax("BR", 0.30);
        Assert.assertEquals(tax.size(), 3);
    }

    // add three entries, none already in dictionary
    public void tax_tests_3(){
        setup();
        tax.addTax("CO", 0.10);
        tax.addTax("AR", 0.20);
        tax.addTax("CH", 0.30);
        Assert.assertEquals(tax.size(), 5);
    }

    // AdditionalTax
    // add one entry, one resulting
    public void addtax_tests_1(){
        setup();
        addtax.addTax("CO", 0.10);
        Assert.assertEquals(addtax.size(), 1);
    }

    // add three entries, none already in dictionary
    public void addtax_tests_2(){
        setup();
        addtax.addTax("CO", 0.10);
        addtax.addTax("PE", 0.20);
        addtax.addTax("BR", 0.30);
        Assert.assertEquals(addtax.size(), 3);
    }

    // add three entries, two already in dictionary
    public void addtax_tests_3(){
        setup();
        addtax.addTax("PE", 0.20);
        addtax.addTax("BR", 0.30);

        addtax.addTax("CO", 0.10);
        addtax.addTax("PE", 0.20);
        addtax.addTax("BR", 0.30);
        Assert.assertEquals(addtax.size(), 3);
    }

    // Tax
    // missing tax should be 0.0
    public void tax_calc_tests_1(){
        setup();
        Assert.assertEquals(tax.calculateTax("PE"), 0.18);
        Assert.assertEquals(tax.calculateTax("BR"), 0.12);
        Assert.assertEquals(tax.calculateTax("AR"), 0.0);
    }

    // AdditionalTax
    // CO as default country, missing tax should be 0.10
    public void addtax_calc_tests_1(){
        setup();
        addtax.addTax("CO", 0.10);
        addtax.addTax("PE", 0.20);
        addtax.addTax("BR", 0.30);
        addtax.setDefaultcountry("CO");

        Assert.assertEquals(addtax.calculateTax("CO"), 0.10);
        Assert.assertEquals(addtax.calculateTax("PE"), 0.20);
        Assert.assertEquals(addtax.calculateTax("BR"), 0.30);
        Assert.assertEquals(addtax.calculateTax("AR"), 0.10);
    }

    // no default (or missing) country, missing tax should be 0.0
    public void addtax_calc_tests_2(){
        setup();
        addtax.addTax("CO", 0.10);
        addtax.addTax("PE", 0.20);
        addtax.addTax("BR", 0.30);

        Assert.assertEquals(addtax.calculateTax("CO"), 0.10);
        Assert.assertEquals(addtax.calculateTax("PE"), 0.20);
        Assert.assertEquals(addtax.calculateTax("BR"), 0.30);
        Assert.assertEquals(addtax.calculateTax("AR"), 0.0);
    }
}
