package lab.demand;

// Tax class specialization
public class Tax extends TaxParentClass {

    // default constructor, with set PE and BR tax values
    public Tax(){
        addTax("PE", 0.18);
        addTax("BR", 0.12);
    }
}

