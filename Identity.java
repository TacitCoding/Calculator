public class Identity extends Function {

    public Identity() {}


//----------------Addition----------------\\
    @Override
    public Type add(Type other) {return other.addToIdentity(this);}

    @Override
    public Type addToInteger(Integer other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToDouble(Double other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToFraction(Fraction other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToIdentity(Identity other) {return new Product(new Type[] {this, new Integer(2)});}
    @Override
    public Type addToPower(Power other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToSum(Sum other) {return new Sum(new Type[] {this, other});}
    @Override
    public Type addToProduct(Product other) {return new Sum(new Type[] {this, other});}
//----------------------------------------\\


//----------------Subtraction----------------\\
    @Override
    public Type subtract(Type other) {return other.negate().addToIdentity(this);}
//-------------------------------------------\\


//----------------Multiplication----------------\\
    @Override
    public Type multiply(Type other) {return other.multiplyToIdentity(this);}

    @Override
    public Type multiplyToInteger(Integer other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToDouble(Double other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToFraction(Fraction other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToIdentity(Identity other) {return new Power(this, new Integer(2));}
    @Override
    public Type multiplyToPower(Power other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToSum(Sum other) {return new Product(new Type[] {this, other});}
    @Override
    public Type multiplyToProduct(Product other) {return new Product(new Type[] {this, other});}
//----------------------------------------\\


//----------------Division----------------\\
    @Override
    public Type divide(Type other) {return other.reciprocal().multiplyToIdentity(this);}
//-------------------------------------------\\


//----------------------------------------\\
    @Override
    public Type pow(Integer n) {return new Power(this, n);}

    @Override
    public Type negate() {return this.multiply(new Integer(-1));}

    @Override
    public Type reciprocal() {return new Power(this, new Integer(-1));}
//----------------------------------------\\


 //-----------equals---------------\\
    @Override
    public boolean equals(Type other) {return other.equalsIdentity(this);}

    @Override
    public boolean equalsInteger(Identity other) {return false;}
    @Override
    public boolean equalsDouble(Double other) {return false;}
    @Override
    public boolean equalsFraction(Fraction other) {return false;}
    @Override
    public boolean equalsIdentity(Identity other) {return true;}
    @Override
    public boolean equalsPower(Power other) {return other.getBase().equalsIdentity(this) && other.getExpo().equalsInteger(new Integer(1));}
    @Override
    public boolean equalsSum(Sum other) {return (other.getTerms().length == 1) && other.getTerms()[0].equals(this);}
    @Override
    public boolean equalsProduct(Product other) {return (other.getTerms().length == 1) && other.getTerms()[0].equals(this);}
//----------------------------------------\\


//----------------Solve stuff------------------\\
    public Type SolveX(Type y) {return y;}

    public Type SolveY(Type x) {return x;}
//----------------------------------------\\


//----------------Derivative and Anti-------------------\\
    @Override
    public Type derivative() {return new Integer(1);}

    @Override
    public Type antiderivative() {return new Product(new Type[] {new Fraction(1, 2), new Power(this, new Integer(2))});}
//----------------------------------------\\


//---------------String----------------\\
    @Override
    public String toString() {return "x";}
//-------------------------------------\\

}