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