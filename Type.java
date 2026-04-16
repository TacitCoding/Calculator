public abstract class Type {

    public abstract Type add(Type other);

    public abstract Type addToInteger(Integer other);
    public abstract Type addToDouble(Double other);
    public abstract Type addToFraction(Fraction other);
    public abstract Type addToIdentity(Identity other);
    public abstract Type addToPower(Power other);
    public abstract Type addToSum(Sum other);
    public abstract Type addToProduct(Product other);


    public abstract Type subtract(Type other);


    public abstract Type multiply(Type other);

    public abstract Type multiplyToInteger(Integer other);
    public abstract Type multiplyToDouble(Double other);
    public abstract Type multiplyToFraction(Fraction other);
    public abstract Type multiplyToIdentity(Identity other);
    public abstract Type multiplyToPower(Power other);
    public abstract Type multiplyToSum(Sum other);
    public abstract Type multiplyToProduct(Product other);


    public abstract Type divide(Type other);


    public abstract Type pow(Integer other);


    public abstract Type negate();


    public abstract Type reciprocal();


    public abstract boolean equals(Type other);

    public abstract boolean equalsInteger(Integer other);
    public abstract boolean equalsDouble(Double other);
    public abstract boolean equalsFraction(Fraction other);
    public abstract boolean equalsIdentity(Identity other);
    public abstract boolean equalsPower(Power other);
    public abstract boolean equalsSum(Sum other);
    public abstract boolean equalsProduct(Product other);
    

    public abstract Type derivative();
    public abstract Type antiderivative();

    public abstract String toString();
}