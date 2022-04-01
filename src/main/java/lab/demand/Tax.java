package lab.demand;

import lab.demand.TaxParentClass;

// Tax class specialization
public class Tax extends TaxParentClass {

    // default constructor, with set PE and BR tax values
    public Tax(){
        TaxTable.put("PE", 0.18);
        TaxTable.put("BR", 0.12);
    }
}

