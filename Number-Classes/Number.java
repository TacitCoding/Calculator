public abstract class Number {

    public abstract String toString();
    
    public abstract Number add(Number other);
    public abstract Number subtract(Number other);
    public abstract Number multiply(Number other);
    public abstract Number divide(Number other);
    public abstract Number pow(Number other);

    public abstract boolean lt(Number other);
    public abstract boolean le(Number other);
    public abstract boolean e(Number other);
    public abstract boolean ge(Number other);
    public abstract boolean gt(Number other);


}