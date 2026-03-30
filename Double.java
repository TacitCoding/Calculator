public class Double extends Number {


    private final double value;

    public Double(double value) {
        this.value = value;
    }

    public double getValue() {return this.value;}

//----------------Addition----------------\\
    @Override
    public Type add(Type other) {
        if (other instanceof Number) {return this.add((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number add(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Double(this.getValue() + ((Integer) other).getValue());}
        if (other instanceof Double) {newNum = new Double(this.getValue() + ((Double) other).getValue());}
        if (other instanceof Fraction) {newNum = ((Fraction) other).add(this);}
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
        if (other instanceof Integer) {newNum = new Double(this.getValue() - ((Integer) other).getValue());}
        if (other instanceof Double) {newNum = new Double(this.getValue() - ((Double) other).getValue());}
        if (other instanceof Fraction) {newNum = (Number) (((Fraction) other).negate()).add(this);}
        return newNum;
    }

    //public Function add(Function other) {

        //if (other instanceof Identity)
        //if (other instanceof Polynomial)   
        //return newNum;
    //}
//----------------------------------------\\


//----------------multiplication----------------\\
    @Override
    public Type multiply(Type other) {
        if (other instanceof Number) {return this.multiply((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number multiply(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Double(this.getValue() * ((Integer) other).getValue());}
        if (other instanceof Double) {newNum = new Double(this.getValue() * ((Double) other).getValue());}
        if (other instanceof Fraction) {newNum = ((Fraction) other).multiply(this);}
        return newNum;
    }

    //public Function add(Function other) {

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
        if (other instanceof Integer) {newNum = new Double(this.getValue() / ((Integer) other).getValue());}
        if (other instanceof Double) {newNum = new Double(this.getValue() / ((Double) other).getValue());}
        if (other instanceof Fraction) {Fraction o = (Fraction) other; newNum = (new Fraction(o.getDen(), o.getNum())).multiply(this);}
        return newNum;
    }

    //public Function add(Function other) {

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
        double newDub = 1.0;
        for (int i = 1; i < n.getValue(); i++) {newDub *= this.value;}
        if (negate) {return new Double(1 / newDub);}
        return new Double(newDub);
    }

    @Override
    public Type negate() {return new Double(this.getValue() * -1);}
//----------------------------------------\\


//----------------equals----------------\\
    @Override
    public boolean equals(Type other) {
        if (other instanceof Number) {return this.equals((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public boolean equals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() == ((Integer) other).getValue();}
        if (other instanceof Double) {newNum = this.getValue() == ((Double) other).getValue();}
        if (other instanceof Fraction) {newNum = ((Fraction) other).equals(this);}
        return newNum;
    }
//----------------------------------------\\


//----------------greater-than---------------\\
    @Override
    public boolean greaterThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() > ((Integer) other).getValue();}
        if (other instanceof Double) {newNum = this.getValue() >((Double) other).getValue();}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).greaterThan(this));}
        return newNum;
    }
//----------------------------------------\\


//----------------greater-than-equals--------------\\
    @Override
    public boolean greaterThanOrEquals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() >= ((Integer) other).getValue();}
        if (other instanceof Double) {newNum = this.getValue() >= ((Double) other).getValue();}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).greaterThanOrEquals(this));}
        return newNum;
    }
//----------------------------------------\\


//----------------less-than---------------\\
    @Override
    public boolean lessThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() < ((Integer) other).getValue();}
        if (other instanceof Double) {newNum = this.getValue() < ((Double) other).getValue();}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).lessThan(this));}
        return newNum;
    }
//----------------------------------------\\


//----------------less-than-equals--------------\\
    @Override
    public boolean lessThanOrEquals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() <= ((Integer) other).getValue();}
        if (other instanceof Double) {newNum = this.getValue() <= ((Double) other).getValue();}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).lessThanOrEquals(this));}
        return newNum;
    }
//----------------------------------------\\


    @Override
    public String toString() {return this.value + "";}


    public Fraction toFraction() {
        String str = String.valueOf(this.value);
        int decimalPlaces = 0;

        if (str.contains(".")) {
            decimalPlaces = str.length() - str.indexOf('.') - 1;
            str = str.replace(".", "");
        }

        int numerator = (int) (this.value * ((int) Math.pow(10, decimalPlaces)));
        int denominator = (int) Math.pow(10, decimalPlaces);

        return new Fraction(numerator, denominator);
    }
}