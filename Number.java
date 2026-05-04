public abstract class Number extends Type {


    public abstract boolean greaterThan(Number input);

    public abstract boolean greaterThanInteger(Integer input);
    public abstract boolean greaterThanDouble(Double input);
    public abstract boolean greaterThanFraction(Fraction input);

    public abstract boolean greaterThanOrEquals(Number input);

    public abstract boolean lessThan(Number input);

    public abstract boolean lessThanInteger(Integer input);
    public abstract boolean lessThanDouble(Double input);
    public abstract boolean lessThanFraction(Fraction input);

    public abstract boolean lessThanOrEquals(Number input);

    @Override
    public Type derivative() {return new Integer(0);}

    //@Override
    //public Type antiderivative() {return new Product(new Type[] {this, new Identity()});}

}