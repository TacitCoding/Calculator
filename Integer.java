public class Integer extends Number {

    private final int value;

    public Integer(int num) {this.value = num;}

    public int getValue() {
        return this.value;
    }


//----------------Addition----------------\\
    @Override
    public Type add(Type other) {
        if (other instanceof Number) {return this.add((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number add(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Integer(this.getValue() + ((Integer) other).getValue());}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }

    //public Function add(Function other) {

        //if (other instanceof Identity)
        //if (other instanceof Polynomial)   
        //return newNum;
    //}
//----------------------------------------\\


//----------------Subtraction----------------\\
    @Override
    public Type subtract(Type other) {
        if (other instanceof Number) {return this.subtract((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number subtract(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Integer(this.getValue() - ((Integer) other).getValue());}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }

    //public Function subtract(Function other) {

        //if (other instanceof Identity)
        //if (other instanceof Polynomial)   
        //return newNum;
    //}
//----------------------------------------\\


//----------------Multiplication----------------\\
    @Override
    public Type multiply(Type other) {
       
        if (other instanceof Number) {return this.multiply((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number multiply(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Integer(this.getValue() * ((Integer) other).getValue());}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }

    //public Function multiply(Function other) {

        //if (other instanceof Identity)
        //if (other instanceof Polynomial)   
        //return newNum;
    //}
//----------------------------------------\\


//----------------division----------------\\
    @Override
    public Type divide(Type other) {
        if (other instanceof Number) {return this.divide((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number divide(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Fraction(this.getValue(), ((Integer) other).getValue());}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }

    //public Function divide(Function other) {

        //if (other instanceof Identity)
        //if (other instanceof Polynomial)   
        //return newNum;
    //}
//----------------------------------------\\


//----------------------------------------\\
    @Override
    public Type pow(Integer n) {
        boolean negate = false;
        if (n.lessThan(new Integer(0))) {n = new Integer(n.getValue() * -1); negate = true;}
        Integer newInt = new Integer(1);
        for (int i = 1; i < n.getValue(); i++) {newInt = newInt.multiply(this);}
        if (negate) {return new Fraction(1, newInt.getValue());}
        return newInt;
    }

    @Override
    public Type negate() {return new Integer(this.getValue() * -1);}
//----------------------------------------\\


//----------------greater-than----------------\\
    @Override
    public boolean greaterThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() > ((Integer) other).getValue();}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }
//----------------------------------------\\


//----------------greater-than-or-equals--------------\\
    @Override
    public boolean greaterThanOrEqual(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() >= ((Integer) other).getValue();}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }
//----------------------------------------\\


//----------------less-than--------------\\
    @Override
    public boolean lessThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() < ((Integer) other).getValue();}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }
//----------------------------------------\\


//----------------less-than-or-equal------------\\
    @Override
    public boolean lessThanOrEqual(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() <= ((Integer) other).getValue();}
        //if (other instanceof Double)
        //if (other instanceof Fraction)
        return newNum;
    }
//----------------------------------------\\


    @Override
    public String toString() {
        return this.value + "";
    }
}