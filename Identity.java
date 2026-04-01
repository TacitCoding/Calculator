public class Identity extends Function {

    public Identity() {}

    @Override
    public Type add(Type other) {
        return new Polynomial(new Type[] {other, new Integer(1)});
    }

    @Override
    public Type subtract(Type other) {
        return new Polynomial(new Type[] {other.negate(), new Integer(1)});
    }

    @Override
    public Type multiply(Type other) {
        return new Polynomial(new Type[] {new Integer(0), other});
    }

    //public Type divide(Type other) {
    //    return new Polynomial(new Type[] {other, new Integer(1)});
    //}

    @Override
    public Type pow(Integer n) {
        if (n.getValue() < 0) {throw new ArithmeticException("I have not added rationals");}
        Type[] newPoly = new Type[n.getValue() + 1];
        newPoly[n.getValue()] = new Integer(1);
        return new Polynomial(newPoly);
    }

    @Override
    public Type negate() {
        return new Polynomial(new Type[] {new Integer(0), new Integer(-1)});
    }

    @Override
    public boolean equals(Type other) {
        if (other instanceof Identity) {return true;}
        else return other.equals(this);
    }

    @Override
    public Type solveY(Type input) {return input;}
    @Override
    public Type solveX(Type input) {return input;}

    @Override
    public Type derivative() {return new Integer(1);}

    @Override
    public Type antiderivative() {
        Integer zero = new Integer(0);
        Type[] poly = new Type[] {zero, zero, new Fraction(1, 2)};
        return new Polynomial(poly);
    }

    @Override
    public String toString() {return "x";}



}