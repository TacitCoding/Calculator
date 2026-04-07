public abstract class Number extends Type {

    @Override
    public Type addToIdentity(Identity other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToPower(Power other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToSum(Sum other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToProduct(Product other) {return new Sum(new Type[] {this, other});}

    @Override
    public Type multiplyToIdentity(Identity other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToPower(Power other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToSum(Sum other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToProduct(Product other) {return new Product(new Type[] {this, other});}

    @Override
    public boolean equalsIdentity(Identity other) {return false;}
    @Override
    public boolean equalsPower(Power other) {return this.equalsInteger(new Integer(1)) && other.getExpo().equalsInteger(new Integer(0));}
    @Override
    public boolean equalsSum(Sum other) {return (other.getTerms().length == 1) && other.getTerms()[0].equals(this);}
    @Override
    public boolean equalsProduct(Product other) {return (other.getTerms().length == 1) && other.getTerms()[0].equals(this);}

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

    @Override
    public Type antiderivative() {return new Product(new Type[] {this, new Identity()});}

}