public class Sum extends Function {

    private final Type[] terms;

    public Sum(Type[] terms) {
        //check for at least one function
        this.terms = terms;
    }
}