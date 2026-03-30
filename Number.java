public abstract class Number extends Type {


    public abstract boolean greaterThan(Number input);
    public abstract boolean greaterThanOrEquals(Number input);
    public abstract boolean lessThan(Number input);
    public abstract boolean lessThanOrEquals(Number input);

    @Override
    public Type derivative() {
        return new Integer(0);
    }

    //@Override
    //public Type antiderivative() {} this requires implimentation of other classes that i have yet to add

}