public class Calculator {

    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(3);
        Integer c = new Integer(-2);
        Integer zero = new Integer(0);

        // Addition
        System.out.println(a.add(b));        // 8
        System.out.println(a.add(c));        // 3

        // Subtraction
        System.out.println(a.subtract(b));   // 2
        System.out.println(c.subtract(a));   // -7

        // Multiplication
        System.out.println(a.multiply(b));   // 15
        System.out.println(c.multiply(b));   // -6

        // Division
        System.out.println(a.divide(b));     // 5/3 as Fraction
        System.out.println(a.divide(a));     // 1

        // Pow
        System.out.println(a.pow(new Integer(3)));   // 125
        System.out.println(a.pow(new Integer(-2)));  // 1/25

        // Negate
        System.out.println(a.negate());      // -5

        // Reciprocal
        System.out.println(a.reciprocal());  // 1/5

        // Comparisons
        System.out.println(a.greaterThan(b));         // true
        System.out.println(c.lessThan(b));            // true
        System.out.println(a.equals(new Integer(5))); // true

    
    }

}