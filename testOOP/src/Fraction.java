public class Fraction {
    private int numerator, denominator;

    public Fraction() {
        this(0, 0);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int greatestCommonDivisor(int a, int b) {
        if(b == 0) {
            return a;
        }

        return greatestCommonDivisor(b, a % b);
    }

    public Fraction add(Fraction b) {
        int gcd = greatestCommonDivisor(this.denominator, b.getDenominator());
        int lcm = (this.denominator * b.getDenominator()) / gcd;

        Fraction res = new Fraction();

        res.setDenominator(lcm);
        res.setNumerator(this.numerator * (lcm / this.denominator) + b.getNumerator() * (lcm / b.getDenominator()));

        return res;
    }

    public Fraction substract(Fraction b) {
        int gcd = greatestCommonDivisor(this.denominator, b.getDenominator());
        int lcm = (this.denominator * b.getDenominator()) / gcd;

        Fraction res = new Fraction();

        res.setDenominator(lcm);
        res.setNumerator(this.numerator * (lcm / this.denominator) - b.getNumerator() * (lcm / b.getDenominator()));

        return res;
    }

    public Fraction multiply(Fraction b) {
        Fraction res = new Fraction();

        res.setNumerator(b.getNumerator() * this.numerator);
        res.setDenominator(b.getDenominator() * this.denominator);

        return res;
    }

    public Fraction divide(Fraction b) {
        Fraction res = new Fraction();

        res.setNumerator(b.getDenominator() * this.numerator);
        res.setDenominator(b.getNumerator() * this.denominator);

        return res;
    }

    public void compute() {
        System.out.println((double) this.numerator / this.denominator + "");
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
