package lab.demand;
import java.util.HashMap;
import java.util.Hashtable;


// parent class for tax structures
class TaxParentClass {
    protected HashMap<String, Double> taxTable = new HashMap<>();

    public double size(){
        return taxTable.size();
    }

    // default constructor
    public TaxParentClass(){}

    // add tax value for a given country, adding to the dictionary
    public void addTax(String country, Double Value){
        taxTable.put(country, Value);
    }

    // returns tax value for a given country, returning a set default value if not present
    public double calculateTax(String country) { return taxTable.getOrDefault(country,0.0); }
}
