public class Double extends Number {


    private final double value;

    public Double(double value) {
        this.value = value;
    }

    public double getValue() {return this.value;}

//----------------Addition----------------\\
    @Override
    public Type add(Type other) {return other.addToDouble(this);}

    @Override
    public Type addToInteger(Integer other) {return new Double(this.value + other.getValue());}
    @Override
    public Type addToDouble(Double other) {return new Double(this.value + other.getValue());}
    @Override
    public Type addToFraction(Fraction other) {return (this.toFraction()).add(other);}
//----------------------------------------\\


//----------------Subtraction----------------\\
    @Override
    public Type subtract(Type other) {return (other.negate()).add(this);}
//----------------------------------------\\


//----------------Multiplication----------------\\
    @Override
    public Type multiply(Type other) {return other.multiplyToDouble(this);}

    @Override
    public Type multiplyToInteger(Integer other) {return new Double(this.value * other.getValue());}
    @Override
    public Type multiplyToDouble(Double other) {return new Double(this.value * other.getValue());}
    @Override
    public Type multiplyToFraction(Fraction other) {return other.multiplyToDouble(this);}
//----------------------------------------\\


//----------------division----------------\\
    @Override
    public Type divide(Type other) {return other.reciprocal().multiply(this);}
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

    @Override
    public Type reciprocal() {return this.toFraction().reciprocal();}
//----------------------------------------\\


//----------------equals----------------\\
    @Override
    public boolean equals(Type other) {return other.equalsDouble(this);}

    @Override
    public boolean equalsInteger(Integer other) {return other.getValue() == this.value;}
    @Override
    public boolean equalsDouble(Double other) {return other.value == this.value;}
    @Override
    public boolean equalsFraction(Fraction other) {return this.toFraction().equalsFraction(other);}
//----------------------------------------\\


//----------------greater-than---------------\\
    @Override
    public boolean greaterThan(Number other) {return other.lessThanDouble(this) || other.equalsDouble(this);}

    @Override
    public boolean greaterThanInteger(Integer other) {return other.getValue() <= this.value;}
    @Override
    public boolean greaterThanDouble(Double other) {return other.value <= this.value;}
    @Override
    public boolean greaterThanFraction(Fraction other) {return this.toFraction().greaterThanFraction(other);}
//----------------------------------------\\


//----------------greater-than-or-equals--------------\\
    @Override
    public boolean greaterThanOrEquals(Number other) {return this.greaterThan(other) || this.equals(other);}
//----------------------------------------\\


//----------------less-than--------------\\
    @Override
    public boolean lessThan(Number other) {return !(this.greaterThanOrEquals(other));}

    @Override
    public boolean lessThanInteger(Integer other) {return other.getValue() >= this.value;}
    @Override
    public boolean lessThanDouble(Double other) {return other.value >= this.value;}
    @Override
    public boolean lessThanFraction(Fraction other) {return this.toFraction().lessThanFraction(other);}
//----------------------------------------\\


//----------------less-than-or-equal------------\\
    @Override
    public boolean lessThanOrEquals(Number other) {return !(this.greaterThan(other));}
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