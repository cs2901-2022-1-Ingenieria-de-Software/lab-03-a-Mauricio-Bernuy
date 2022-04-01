package lab.demand;

import lab.demand.TaxParentClass;

public class Tax extends TaxParentClass {

    public Tax(){ // default constructor
        TaxTable.put("PE", 0.18);
        TaxTable.put("BR", 0.12);
    }
}

