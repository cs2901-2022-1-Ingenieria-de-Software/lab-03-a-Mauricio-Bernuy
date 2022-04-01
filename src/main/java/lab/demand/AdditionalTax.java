package lab.demand;

import lab.demand.TaxParentClass;

// AdditionalTax class specialization
public class AdditionalTax extends TaxParentClass {
    // Default country value to use for the
    String defaultcountry = "";

    //
    public void setDefaultcountry(String def){this.defaultcountry = def;}

    public AdditionalTax() { // default constructor
    }
    public double calculateTax(String country) { return TaxTable.getOrDefault(country,TaxTable.getOrDefault(defaultcountry,0.0)); }

}
