public class Calculator {

    public static void main(String[] args) {
        Number num1 = new Integer(3);
        Number num2 = new Double(2.34);
        Number num3 = new Fraction(4, 3);
        System.out.println(num1 + " " + num2 + " " + num3);

        System.out.println("--pow--");
        System.out.println(num1.pow((Integer) num1));
        System.out.println(num2.pow((Integer) num1));
        System.out.println(num3.pow((Integer) num1));
        System.out.println();

        System.out.println("--equals--");
        System.out.println(num1 + " == " + num1 + " = " + num1.equals(num1));
        System.out.println(num2 + " == " + num2 + " = " + num2.equals(num2));
        System.out.println(num3 + " == " + num3 + " = " + num3.equals(num3));
        System.out.println(num1 + " == " + num2 + " = " + num1.equals(num2));
        System.out.println(num2 + " == " + num1 + " = " + num2.equals(num1));
        System.out.println(num3 + " == " + num1 + " = " + num3.equals(num1));
        System.out.println(num1 + " == " + num3 + " = " + num1.equals(num3));
        System.out.println(num2 + " == " + num3 + " = " + num2.equals(num3));
        System.out.println(num3 + " == " + num2 + " = " + num3.equals(num2));
        System.out.println();

        System.out.println("--greater than--");
        System.out.println(num1 + " > " + num1 + " = " + num1.greaterThan(num1));
        System.out.println(num2 + " > " + num2 + " = " + num2.greaterThan(num2));
        System.out.println(num3 + " > " + num3 + " = " + num3.greaterThan(num3));
        System.out.println(num1 + " > " + num2 + " = " + num1.greaterThan(num2));
        System.out.println(num2 + " > " + num1 + " = " + num2.greaterThan(num1));
        System.out.println(num3 + " > " + num1 + " = " + num3.greaterThan(num1));
        System.out.println(num1 + " > " + num3 + " = " + num1.greaterThan(num3));
        System.out.println(num2 + " > " + num3 + " = " + num2.greaterThan(num3));
        System.out.println(num3 + " > " + num2 + " = " + num3.greaterThan(num2));
        System.out.println();

        System.out.println("--greater than equals--");
        System.out.println(num1 + " >= " + num1 + " = " + num1.greaterThanOrEquals(num1));
        System.out.println(num2 + " >= " + num2 + " = " + num2.greaterThanOrEquals(num2));
        System.out.println(num3 + " >= " + num3 + " = " + num3.greaterThanOrEquals(num3));
        System.out.println(num1 + " >= " + num2 + " = " + num1.greaterThanOrEquals(num2));
        System.out.println(num2 + " >= " + num1 + " = " + num2.greaterThanOrEquals(num1));
        System.out.println(num3 + " >= " + num1 + " = " + num3.greaterThanOrEquals(num1));
        System.out.println(num1 + " >= " + num3 + " = " + num1.greaterThanOrEquals(num3));
        System.out.println(num2 + " >= " + num3 + " = " + num2.greaterThanOrEquals(num3));
        System.out.println(num3 + " >= " + num2 + " = " + num3.greaterThanOrEquals(num2));
        System.out.println();

        System.out.println("--less than--");
        System.out.println(num1 + " < " + num1 + " = " + num1.lessThan(num1));
        System.out.println(num2 + " < " + num2 + " = " + num2.lessThan(num2));
        System.out.println(num3 + " < " + num3 + " = " + num3.lessThan(num3));
        System.out.println(num1 + " < " + num2 + " = " + num1.lessThan(num2));
        System.out.println(num2 + " < " + num1 + " = " + num2.lessThan(num1));
        System.out.println(num3 + " < " + num1 + " = " + num3.lessThan(num1));
        System.out.println(num1 + " < " + num3 + " = " + num1.lessThan(num3));
        System.out.println(num2 + " < " + num3 + " = " + num2.lessThan(num3));
        System.out.println(num3 + " < " + num2 + " = " + num3.lessThan(num2));
        System.out.println();

        System.out.println("--less than equals--");
        System.out.println(num1 + " <= " + num1 + " = " + num1.lessThanOrEquals(num1));
        System.out.println(num2 + " <= " + num2 + " = " + num2.lessThanOrEquals(num2));
        System.out.println(num3 + " <= " + num3 + " = " + num3.lessThanOrEquals(num3));
        System.out.println(num1 + " <= " + num2 + " = " + num1.lessThanOrEquals(num2));
        System.out.println(num2 + " <= " + num1 + " = " + num2.lessThanOrEquals(num1));
        System.out.println(num3 + " <= " + num1 + " = " + num3.lessThanOrEquals(num1));
        System.out.println(num1 + " <= " + num3 + " = " + num1.lessThanOrEquals(num3));
        System.out.println(num2 + " <= " + num3 + " = " + num2.lessThanOrEquals(num3));
        System.out.println(num3 + " <= " + num2 + " = " + num3.lessThanOrEquals(num2));
        System.out.println();

    
    }

}