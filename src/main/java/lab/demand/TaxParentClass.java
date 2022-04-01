package lab.demand;
import java.util.Hashtable;


// parent class for tax structures
class TaxParentClass {
    public Hashtable<String, Double> TaxTable = new Hashtable<String, Double>();

    // default constructor
    public TaxParentClass(){}

    // add tax value for a given country, adding to the dictionary
    public void addTax(String country, Double Value){
        TaxTable.put(country, Value);
    }

    // returns tax value for a given country, returning a set default value if not present
    public double calculateTax(String country) { return TaxTable.getOrDefault(country,0.0); }
}
