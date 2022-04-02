package lab.demand;

// AdditionalTax class specialization
public class AdditionalTax extends TaxParentClass {
    // Default country value to use for the
    String defaultcountry = "";

    public void setDefaultCountry(String def){this.defaultcountry = def;}

    @Override
    public double calculateTax(String country) { return taxTable.getOrDefault(country, taxTable.getOrDefault(defaultcountry,0.0)); }

}
