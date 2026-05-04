public class Calculator {

    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(3);
        Integer c = new Integer(-2);
        Integer d = new Integer(0);

        System.out.println("__Integers__");
        System.out.println("a  =  " + a.toString());
        System.out.println("b  =  " + b.toString());
        System.out.println("c  =  " + c.toString());
        System.out.println("d  =  " + d.toString());

        Double e = new Double(3.23);
        Double f = new Double(-2.67);
        Double g = new Double(10.01);
        Double h = new Double(0);

        System.out.println();
        System.out.println("__Doubles__");
        System.out.println("e  =  " + e.toString());
        System.out.println("f  =  " + f.toString());
        System.out.println("g  =  " + g.toString());
        System.out.println("h  =  " + h.toString());

        Fraction i = new Fraction(5, 3);
        Fraction j = new Fraction(42, 43);
        Fraction k = new Fraction(-2, -16);
        Fraction l = new Fraction(0);

        System.out.println();
        System.out.println("__Fractions__");
        System.out.println("i  =  " + i.toString());
        System.out.println("j  =  " + j.toString());
        System.out.println("k  =  " + k.toString());
        System.out.println("l  =  " + l.toString());
    
    }

}