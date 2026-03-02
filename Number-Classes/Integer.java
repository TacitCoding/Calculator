public class Integer extends Number {
    
    private int value;

    public Integer(int n) {
        this.value = n;
    }

    @Override
    public String toString() {
        return this.value + "";
    }

    @Override
    public Number add(Integer other) {
        return new Integer(this.value + other.value);
    }

    @Override
    public Number subtract(Integer other) {
        return new Integer(this.add(other.multiply(new Integer(-1))));
    }

    @Override
    public Number multiply(Integer other) {
        return new Integer(this.value * other.value)
    }

    @Override
    public Number divide(Integer other) { //needs fractions
        return this;
    }

    @Override
    public Number pow(int n) {
        Integer start = 1;
        for (int i = 1; i <= Math.abs(n); i++) {
            start = start.multiply(this);
        }
        return start; //need to add 1/x^n
    }

    

}