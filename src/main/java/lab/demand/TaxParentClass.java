package lab.demand;
import java.util.HashMap;

// parent class for tax structures
class TaxParentClass {
    protected HashMap<String, Double> taxTable = new HashMap<>();

    public double size(){
        return taxTable.size();
    }

    // add tax value for a given country, adding to the dictionary
    public void addTax(String country, Double value){
        taxTable.put(country, value);
    }

    // returns tax value for a given country, returning a set default value if not present
    public double calculateTax(String country) { return taxTable.getOrDefault(country,0.0); }
}
