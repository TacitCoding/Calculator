public class Power extends Function {

    private final Function base;
    private final Number expo;

    public Power(Number exponent) {
        this.base = new Identity();
        this.expo = exponent;
    }

    public Power(Function base, Number expo) {
        if (base instanceof Power) {
            Power baseNew = (Power) base;
            this.base = baseNew.base;
            this.expo = (Number) baseNew.expo.multiply(expo);
        }
        this.base = base;
        this.expo = expo;
    }

    public Power(Type base, Type expo) {
        if (!(base instanceof Function) || !(expo instanceof Number)) {throw new IllegalArgumentException("must be a function base and number exponent");}
        if (base instanceof Power) {
            Power baseNew = (Power) base;
            this.base = baseNew.base;
            this.expo = (Number) baseNew.expo.multiply(expo);
        }
        this.base = (Function) base;
        this.expo = (Number) expo;
    }

    public Function getBase() {return this.base;}
    public Number getExpo() {return this.expo;}


//----------------addition-------------------\\
    @Override
    public Type add(Type other) {
        if (this.expo.equals(new Integer(0))) {return other.addToInteger(new Integer(1));}
        return other.addToPower(this);
    }

    @Override
    public Type addToInteger(Integer other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToDouble(Double other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToFraction(Fraction other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToIdentity(Identity other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToPower(Power other) {return new Product(new Type[] {this, new Integer(2)});}
    @Override
    public Type addToSum(Sum other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToProduct(Product other) {return new Sum(new Type[] {this, other});}
//---------------------------------------\\


//--------------Subtraction----------------\\
    @Override
    public Type subtract(Type other) {return other.negate().addToPower(this);}
//---------------------------------------\\


//----------------multiplication-------------------\\
    @Override
    public Type multiply(Type other) {
        if (this.expo.equals(new Integer(0))) {return other;}
        return other.multiplyToPower(this);
    }

    @Override
    public Type multiplyToInteger(Integer other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToDouble(Double other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToFraction(Fraction other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToIdentity(Identity other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToPower(Power other) {return new Power(this, new Integer(2));}
    @Override
    public Type multiplyToSum(Sum other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToProduct(Product other) {return new Product(new Type[] {this, other});}
//---------------------------------------\\


//----------------divide-------------------\\
    @Override
    public Type divide(Type other) {
        if (this.expo.equals(new Integer(0))) {return other;}
        return other.reciprocal().multiplyToPower(this);
    }
//---------------------------------------\\


//---------------------------------------\\
    @Override
    public Type pow(Integer n) {return new Power(this, n);}

    @Override
    public Type negate() {return new Product(new Type[] {this, new Integer(-1)});}

    @Override
    public Type reciprocal() {return new Power(this.base, this.expo.negate());}
//---------------------------------------\\


//------------------equals---------------------\\
    @Override
    public boolean equals(Type other) {return other.equalsPower(this);}

    @Override
    public boolean equalsInteger(Integer other) {
        if (other.equalsInteger(new Integer(1)) && this.expo.equals(new Integer(0))) {return true;}
        return false;
    }
    @Override
    public boolean equalsDouble(Double other) {
        if (other.equalsInteger(new Integer(1)) && this.expo.equals(new Integer(0))) {return true;}
        return false;
    }
    @Override
    public boolean equalsFraction(Fraction other) {
        if (other.equalsInteger(new Integer(1)) && this.expo.equals(new Integer(0))) {return true;}
        return false;
    }
    @Override
    public boolean equalsIdentity(Identity other) {
        if (this.base instanceof Identity && this.expo.equalsInteger(new Integer(1))) {return true;}
        return false;
    }
    @Override
    public boolean equalsPower(Power other) {
        if (this.base.equals(other.base) && this.expo.equals(other.expo)) {return true;}
        return false;
    }
    @Override
    public boolean equalsSum(Sum other) {
        Type[] terms = other.getTerms();
        if (terms.length == 1 && terms[0].equalsPower(this)) {return true;}
        if (this.base instanceof Sum && this.base.equalsSum(other)) {return true;}
        return false;
    }
    @Override
    public boolean equalsProduct(Product other) {
        Type[] terms = other.getTerms();
        if (terms.length == 1 && terms[0].equalsPower(this)) {return true;}
        if (this.base instanceof Product && this.base.equalsProduct(other)) {return true;}
        return false;
    }
//---------------------------------------\\


//---------------------------------------\\
    @Override
    public Type derivative() {
        Type[] terms = new Type[2];
        terms[0] = this.expo;
        terms[1] = new Power(this.base, this.expo.subtract(new Integer(1)));
        return new Product(terms);
    }

    @Override
    public Type antiderivative() {
        Type[] terms = new Type[2];
        terms[0] = this.expo.reciprocal();
        terms[1] = new Power(this.base, this.expo.add(new Integer(1)));
        return new Product(terms);
    }
//---------------------------------------\\


//---------------------------------------\\
    @Override
    public String toString() {
        String strPow = "";
        if (this.base instanceof Sum || this.base instanceof Product) {strPow += "(" + this.base.toString() + ")";}
        else {strPow += this.base.toString();}
        return strPow + "^" + this.expo.toString();
    }
    




}