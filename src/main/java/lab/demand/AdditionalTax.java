package lab.demand;

import lab.demand.TaxParentClass;

public class AdditionalTax extends TaxParentClass {
    String defaultcountry = "CO";
    public void setDefaultcountry(String def){this.defaultcountry = def;}

    public AdditionalTax() { // default constructor
    }
    public double calculateTax(String country) {
        return TaxTable.getOrDefault(country,TaxTable.get(defaultcountry));
    }

}
