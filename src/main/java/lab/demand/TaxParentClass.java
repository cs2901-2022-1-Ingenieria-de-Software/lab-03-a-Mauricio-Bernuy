package lab.demand;
import java.util.Hashtable;

class TaxParentClass {
    Hashtable<String, Double> TaxTable = new Hashtable<String, Double>();

    public TaxParentClass(){ // default constructor
    }
    public void addTax(String country, Double Value){
        TaxTable.put(country, Value);
    }

    public double calculateTax(String country) {
        return TaxTable.getOrDefault(country,0.0);
    }
}
