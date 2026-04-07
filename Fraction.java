public class Fraction extends Number {

    private final int num, den;

    public Fraction(int num, int den) { 
        if (den == 0) {throw new ArithmeticException("denominator can't be zero!");} //the ;}
        if (num == 0) {this.num = 0; this.den = 1;}
         else { 
            if (num < 0 && den < 0) {num  = num * -1; den = den * -1;}
        
            if (num > 0 && den < 0) {num = num * -1; den = den * -1;}
        
            int factor = gcf(num, den);
        
            this.num = num / factor;
            this.den  = den / factor;
         }
    }

    public Fraction(Integer numer, Integer denom) {
        int num = numer.getValue();
        int den = denom.getValue();
        if (den == 0) {throw new ArithmeticException("denominator can't be zero!");}
        if (num == 0) {this.num = 0; this.den = 1;}
         else { 
            if (num < 0 && den < 0) {num  = num * -1; den = den * -1;}
        
            if (num > 0 && den < 0) {num = num * -1; den = den * -1;}
        
            int factor = gcf(num, den);
        
            this.num = num / factor;
            this.den  = den / factor;
         }
    }

    public Fraction(int num) {this.num = num; this.den = 1;}
    public Fraction(Integer num) {this.num = num.getValue(); this.den = 1;}

    public int getNum() {return this.num;}
    public int getDen() {return this.den;}



//----------------Addition----------------\\
    @Override
    public Type add(Type other) {return other.addToFraction(this);}

    @Override
    public Type addToInteger(Integer other) {return new Fraction(this.num + other.getValue() * this.den, this.den);}
    @Override
    public Type addToDouble(Double other) {return this.add(other.toFraction());}
    @Override
    public Type addToFraction(Fraction other) {return new Fraction(this.num * other.den + other.num * this.den, this.den * other.den);}
//----------------------------------------\\


//----------------Subtraction----------------\\
    @Override
    public Type subtract(Type other) {return (other.negate()).add(this);}
//----------------------------------------\\


//----------------Multiplication----------------\\
    @Override
    public Type multiply(Type other) {return other.multiplyToFraction(this);}

    @Override
    public Type multiplyToInteger(Integer other) {return new Fraction(other.getValue() * this.num, this.den);}
    @Override
    public Type multiplyToDouble(Double other) {return this.multiply(other.toFraction());}
    @Override
    public Type multiplyToFraction(Fraction other) {return new Fraction(this.num * other.num, this.den * other.den);}
//----------------------------------------\\


//----------------Division----------------\\
    @Override
    public Type divide(Type other) {return (other.reciprocal()).multiply(this);}
//----------------------------------------\\


//----------------------------------------\\
    @Override
    public Type pow(Integer n) {
        boolean negate = false;
        if (n.lessThan(new Integer(0))) {n = new Integer(n.getValue() * -1); negate = true;}

        int newNum = 1;
        int newDen = 1;

        for (int i = 1; i < n.getValue(); i++) {
            newNum *= this.getNum();
            newDen *= this.getDen();
        }
        if (negate) {return new Fraction(newDen, newNum);}
        return new Fraction(newNum, newDen);


    }

    @Override
    public Type negate() {return new Fraction(this.num * -1, this.den);}

    @Override
    public Type reciprocal() {return new Fraction(this.den, this.num);}
//----------------------------------------\\


//----------------equals----------------\\
    @Override
    public boolean equals(Type other) {return other.equalsFraction(this);}

    @Override
    public boolean equalsInteger(Integer other) {return (other.getValue() == this.num) && (this.den == 1);}
    @Override
    public boolean equalsDouble(Double other) {return this.equalsFraction(other.toFraction());}
    @Override
    public boolean equalsFraction(Fraction other) {return (other.num == this.num) && (other.den == this.den);}
//----------------------------------------\\


//----------------greater-than---------------\\
    @Override
    public boolean greaterThan(Number other) {return other.lessThanFraction(this) || other.equalsFraction(this);}

    @Override
    public boolean greaterThanInteger(Integer other) {return other.getValue() * this.getDen() > this.getNum();}
    @Override
    public boolean greaterThanDouble(Double other) {return this.greaterThanFraction(other.toFraction());}
    @Override
    public boolean greaterThanFraction(Fraction other) {return (this.num*other.den > this.den*other.num);}
//----------------------------------------\\


//----------------greater-than-or-equals--------------\\
    @Override
    public boolean greaterThanOrEquals(Number other) {return this.greaterThan(other) || this.equals(other);}
//----------------------------------------\\


//----------------less-than--------------\\
    @Override
    public boolean lessThan(Number other) {return !(this.greaterThanOrEquals(other));}
//----------------------------------------\\


//----------------less-than-or-equal------------\\
    @Override
    public boolean lessThanOrEquals(Number other) {return !(this.greaterThan(other));}

    @Override
    public boolean lessThanInteger(Integer other) {return other.getValue() * this.getDen() < this.getNum();}
    @Override
    public boolean lessThanDouble(Double other) {return this.lessThanFraction(other.toFraction());}
    @Override
    public boolean lessThanFraction(Fraction other) {return (this.num*other.den < this.den*other.num);}
//----------------------------------------\\



    @Override
    public String toString() {
        if (this.den != 1) {return this.num + "/" + this.den;}
        
        return String.valueOf(this.num);
    }








    private int gcf(int m, int n) {
        m = Math.abs(m);
        n = Math.abs(n);
        int e, f;
        e = m; 
        f = n; 
        if (e > f) {n = e; m = f;}
        
        if (n % m == 0) {return m;}
         else {return gcf(m, n % m);}
    }
}