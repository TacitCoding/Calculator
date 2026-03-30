public abstract class Type {

    public abstract Type add(Type other);
    public abstract Type subtract(Type other);
    public abstract Type multiply(Type other);
    public abstract Type divide(Type other);
    public abstract Type pow(Integer other);

    public abstract Type negate();
    //public abstract recipricol(); //will add later

    public abstract boolean equals(Type other);
    public abstract Type derivative();
    //public abstract Type antiderivative();

    public abstract String toString();
}