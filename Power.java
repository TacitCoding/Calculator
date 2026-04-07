public class Power extends Function {

    private final Function base;
    private final Number expo;

    public Power(Number exponent) {
        this.base = new Identity();
        this.expo = exponent;
    }

}