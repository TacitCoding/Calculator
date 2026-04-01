public class Polynomial extends Function {

    private Type[] coeff;
    private Function[] x;

    public Polynomial(Type[] coeff) {
        this.coeff = coeff;
        Function[] x = new Function[coeff.length];
        for (int i = 0; i < coeff.length; i++) {x[i] = new Identity();}
        this.x = x;
    }

    public Type[] getCoeff() {return this.coeff;}

}
