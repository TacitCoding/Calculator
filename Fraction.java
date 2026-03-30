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
    public Type add(Type other) {
        if (other instanceof Number) {return this.add((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number add(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {
            Integer o = (Integer) other; 
            newNum = new Fraction(this.getNum() + o.getValue() * this.getDen(), this.getDen());
        }

        if (other instanceof Double) {newNum = this.add(((Double) other).toFraction());}

        if (other instanceof Fraction) {
            Fraction o = (Fraction) other;
            newNum = new Fraction(this.getNum() * o.getDen() + o.getNum() * this.getDen(), this.getDen() * o.getDen());
        }
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
        if (other instanceof Integer) {
            Integer o = (Integer) other; 
            newNum = new Fraction(this.getNum() - o.getValue() * this.getDen(), this.getDen());
        }

        if (other instanceof Double) {newNum = this.subtract(((Double) other).toFraction());}

        if (other instanceof Fraction) {
            Fraction o = (Fraction) other;
            newNum = new Fraction(this.getNum() * o.getDen() - o.getNum() * this.getDen(), this.getDen() * o.getDen());
        }
        return newNum;
    }

    //public Function add(Function other) {

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
        if (other instanceof Integer) {
            Integer o = (Integer) other; 
            newNum = new Fraction(this.getNum() * o.getValue(), this.getDen());
        }

        if (other instanceof Double) {newNum = this.multiply(((Double) other).toFraction());}

        if (other instanceof Fraction) {
            Fraction o = (Fraction) other;
            newNum = new Fraction(this.getNum() *  o.getNum(), this.getDen() * o.getDen());
        }
        return newNum;
    }

    //public Function add(Function other) {

        //if (other instanceof Identity)
        //if (other instanceof Polynomial)   
        //return newNum;
    //}
//----------------------------------------\\


//----------------Division----------------\\
    @Override
    public Type divide(Type other) {
        if (other instanceof Number) {return this.divide((Number) other);}
        //if (other instanceof Function) {return this.add((Function) other);}

        throw new IllegalArgumentException("Not Included In The Valid Class Types");
    }

    public Number divide(Number other) {
        Number newNum = new Integer(0);
        if (other instanceof Integer) {
            Integer o = (Integer) other; 
            newNum = new Fraction(this.getNum(), this.getDen() * o.getValue());
        }

        if (other instanceof Double) {newNum = this.divide(((Double) other).toFraction());}

        if (other instanceof Fraction) {
            Fraction o = (Fraction) other;
            newNum = new Fraction(this.getNum() *  o.getDen(), this.getDen() * o.getNum());
        }
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

        int newNum = 1;
        int newDen = 1;

        for (int i = 0; i < n.getValue(); i++) {
            newNum *= this.getNum();
            newDen *= this.getDen();
        }
        if (negate) {return new Fraction(newDen, newNum);}
        return new Fraction(newNum, newDen);


    }

    @Override
    public Type negate() {return new Fraction(this.num * -1, this.den);}
//----------------------------------------\\


//----------------equals----------------\\
    @Override
    public boolean equals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getNum() == ((Integer) other).getValue() * this.getDen();}
        if (other instanceof Double) {newNum = this.equals(((Double) other).toFraction());}
        if (other instanceof Fraction) {Fraction o = (Fraction) other; newNum = this.getNum() == o.getNum() && this.getDen() == o.getDen();}
        return newNum;
    }
//----------------------------------------\\


//----------------greater-than----------------\\
    @Override
    public boolean greaterThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getNum() > ((Integer) other).getValue() * this.getDen();}
        if (other instanceof Double) {newNum = this.greaterThan(((Double) other).toFraction());}
        if (other instanceof Fraction) {Fraction o = (Fraction) other; newNum = this.getNum() * o.getDen() > o.getNum() * this.getDen();}
        return newNum;
    }
//----------------------------------------\\


//----------------greater-than-equal---------------\\
    @Override
    public boolean greaterThanOrEquals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getNum() >= ((Integer) other).getValue() * this.getDen();}
        if (other instanceof Double) {newNum = this.greaterThanOrEquals(((Double) other).toFraction());}
        if (other instanceof Fraction) {Fraction o = (Fraction) other; newNum = this.getNum() * o.getDen() >= o.getNum() * this.getDen();}
        return newNum;
    }
//----------------------------------------\\


//----------------less-than----------------\\
    @Override
    public boolean lessThan(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getNum() < ((Integer) other).getValue() * this.getDen();}
        if (other instanceof Double) {newNum = this.lessThan(((Double) other).toFraction());}
        if (other instanceof Fraction) {Fraction o = (Fraction) other; newNum = this.getNum() * o.getDen() < o.getNum() * this.getDen();}
        return newNum;
    }
//----------------------------------------\\


//----------------less-than-equal---------------\\
    @Override
    public boolean lessThanOrEquals(Number other) {
        boolean newNum = false;
        if (other instanceof Integer) {newNum = this.getNum() <= ((Integer) other).getValue() * this.getDen();}
        if (other instanceof Double) {newNum = this.lessThanOrEquals(((Double) other).toFraction());}
        if (other instanceof Fraction) {Fraction o = (Fraction) other; newNum = this.getNum() * o.getDen() <= o.getNum() * this.getDen();}
        return newNum;
    }
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