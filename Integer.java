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
        if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number add(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Integer(this.getValue() + ((Integer) other).getValue());}
        if (other instanceof Double) {Double o = (Double) other; newNum = o.add(this);}
        if (other instanceof Fraction) {newNum = ((Fraction) other).add(this);}
        return newNum;
    }

    public Function add(Function other) {

        if (other instanceof Identity) return other.add(this);
        //if (other instanceof Polynomial)   
        return new Identity();
    }
//----------------------------------------\\


//----------------Subtraction----------------\\
    @Override
    public Type subtract(Type other) {
        if (other instanceof Number) {return this.subtract((Number) other);}
        if (other instanceof Function) {return this.subtract((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number subtract(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Integer(this.getValue() - ((Integer) other).getValue());}
        if (other instanceof Double) {newNum = new Double(this.value - ((Double) other).getValue());}
        if (other instanceof Fraction) {newNum = (Number) (((Fraction) other).negate()).add(this);}
        return newNum;
    }

    public Function subtract(Function other) {

        if (other instanceof Identity) return other.subtract(this);
        //if (other instanceof Polynomial)   
        return new Identity();
    }
//----------------------------------------\\


//----------------Multiplication----------------\\
    @Override
    public Type multiply(Type other) {
       
        if (other instanceof Number) {return this.multiply((Number) other);}
        if (other instanceof Function) {return this.multiply((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number multiply(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {newNum = new Integer(this.getValue() * ((Integer) other).getValue());}
        if (other instanceof Double) {Double o = (Double) other; newNum = o.multiply(this);}
        if (other instanceof Fraction) {newNum = ((Fraction) other).multiply(this);}
        return newNum;
    }

    public Function multiply(Function other) {

        if (other instanceof Identity) return other.multiply(this);
        //if (other instanceof Polynomial)   
        return new Identity();
    }
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
        if (other instanceof Double) {Double o = (Double) other; newNum = new Double(this.value / o.getValue());}
        if (other instanceof Fraction) {Fraction o = (Fraction) other; newNum = (new Fraction(o.getDen(), o.getNum())).multiply(this);}
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
        int newInt = 1;
        for (int i = 1; i < n.getValue(); i++) {newInt *= this.value;}
        if (negate) {return new Fraction(1, newInt);}
        return new Integer(newInt);
    }

    @Override
    public Type negate() {return new Integer(this.getValue() * -1);}
//----------------------------------------\\


//----------------equals----------------\\
    @Override
    public boolean equals(Type other) {
        if (other instanceof Number) {return this.equals((Number) other);}
        if (other instanceof Function) {return this.equals((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public boolean equals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() == ((Integer) other).getValue();}
        if (other instanceof Double) {Double o = (Double) other; newNum = o.equals(this);}
        if (other instanceof Fraction) {newNum = ((Fraction) other).equals(this);}
        return newNum;
    }

    public boolean equals(Function other) {
        if (other instanceof Polynomial) {
            Polynomial o = (Polynomial) other;
            if (o.getCoeff().length == 0 && (o.getCoeff()[0]).equals(this)) {return true;}
        }
        return false;
    }

//----------------------------------------\\


//----------------greater-than----------------\\
    @Override
    public boolean greaterThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() > ((Integer) other).getValue();}
        if (other instanceof Double) {Double o = (Double) other; newNum = !(o.greaterThan(this));}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).greaterThan(this));}
        return newNum;
    }
//----------------------------------------\\


//----------------greater-than-or-equals--------------\\
    @Override
    public boolean greaterThanOrEquals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() >= ((Integer) other).getValue();}
        if (other instanceof Double) {Double o = (Double) other; newNum = !(o.greaterThanOrEquals(this));}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).greaterThanOrEquals(this));}
        return newNum;
    }
//----------------------------------------\\


//----------------less-than--------------\\
    @Override
    public boolean lessThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() < ((Integer) other).getValue();}
        if (other instanceof Double) {Double o = (Double) other; newNum = !(o.lessThan(this));}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).lessThan(this));}
        return newNum;
    }
//----------------------------------------\\


//----------------less-than-or-equal------------\\
    @Override
    public boolean lessThanOrEquals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getValue() <= ((Integer) other).getValue();}
        if (other instanceof Double) {Double o = (Double) other; newNum = !(o.lessThanOrEquals(this));}
        if (other instanceof Fraction) {newNum = !(((Fraction) other).lessThanOrEquals(this));}
        return newNum;
    }
//----------------------------------------\\


    @Override
    public String toString() {
        return this.value + "";
    }
}