public class Product extends Function {

    private final Type[] terms;

    public Product(Type[] terms) {
        //check that atleast one term is a function
        this.terms = terms;
    }
}