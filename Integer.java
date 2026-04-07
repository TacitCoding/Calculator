public class Integer extends Number {

    private final int value;

    public Integer(int num) {this.value = num;}

    public int getValue() {
        return this.value;
    }


//----------------Addition----------------\\
    @Override
    public Type add(Type other) {return other.addToInteger(this);}

    @Override
    public Type addToInteger(Integer other) {return new Integer(this.value + other.value);}
    @Override
    public Type addToDouble(Double other) {return new Double(this.value + other.getValue());}
    @Override
    public Type addToFraction(Fraction other) {return new Fraction(this.value * other.getDen() + other.getNum(), other.getDen());}
//----------------------------------------\\


//----------------Subtraction----------------\\
    @Override
    public Type subtract(Type other) {return (other.negate()).add(this);}
//----------------------------------------\\


//----------------Multiplication----------------\\
    @Override
    public Type multiply(Type other) {return other.multiplyToInteger(this);}

    @Override
    public Type multiplyToInteger(Integer other) {return new Integer(this.value * other.value);}
    @Override
    public Type multiplyToDouble(Double other) {return new Double(this.value * other.getValue());}
    @Override
    public Type multiplyToFraction(Fraction other) {return new Fraction(this.value * other.getNum(), other.getDen());}
//----------------------------------------\\


//----------------division----------------\\
    @Override
    public Type divide(Type other) {return (other.reciprocal()).multiplyToInteger(this);}
//----------------------------------------\\


//----------------------------------------\\
    @Override
    public Type pow(Integer n) {
        boolean negate = false;
        if (n.lessThan(new Integer(0))) {n = new Integer(n.getValue() * -1); negate = true;}
        int newInt = 1;
        for (int i = 0; i < n.getValue(); i++) {
            newInt = newInt * this.value;}
        if (negate) {return new Fraction(1, newInt);}
        return new Integer(newInt);
    }

    @Override
    public Type negate() {return new Integer(this.getValue() * -1);}

    @Override
    public Type reciprocal() {return new Fraction(1, this.value);}
//----------------------------------------\\


//----------------equals----------------\\
    @Override
    public boolean equals(Type other) {return other.equalsInteger(this);}

    @Override
    public boolean equalsInteger(Integer other) {return other.value == this.value;}
    @Override
    public boolean equalsDouble(Double other) {return other.getValue() == this.value;}
    @Override
    public boolean equalsFraction(Fraction other) {return (other.getNum() == this.value) && (other.getDen() == 1);}
//----------------------------------------\\


//----------------greater-than---------------\\
    @Override
    public boolean greaterThan(Number other) {return other.lessThanInteger(this) || other.equalsInteger(this);}

    @Override
    public boolean greaterThanInteger(Integer other) {return this.value > other.value;}
    @Override
    public boolean greaterThanDouble(Double other) {return this.value > other.getValue();}
    @Override
    public boolean greaterThanFraction(Fraction other) {return this.value * other.getDen() > other.getNum();}
//----------------------------------------\\


//----------------greater-than-or-equals--------------\\
    @Override
    public boolean greaterThanOrEquals(Number other) {return this.greaterThan(other) || this.equals(other);}
//----------------------------------------\\


//----------------less-than--------------\\
    @Override
    public boolean lessThan(Number other) {return !(this.greaterThanOrEquals(other));}

    @Override
    public boolean lessThanInteger(Integer other) {return this.value < other.value;}
    @Override
    public boolean lessThanDouble(Double other) {return this.value < other.getValue();}
    @Override
    public boolean lessThanFraction(Fraction other) {return this.value * other.getDen() < other.getNum();}
//----------------------------------------\\


//----------------less-than-or-equal------------\\
    @Override
    public boolean lessThanOrEquals(Number other) {return this.lessThan(other) || this.equals(other);}
//----------------------------------------\\


    @Override
    public String toString() {
        return this.value + "";
    }
}