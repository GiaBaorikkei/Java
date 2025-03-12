class Fraction {
    private int numerator;   // Tử số
    private int denominator; // Mẫu số

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Mẫu số không thể bằng 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) { // Đảm bảo mẫu số luôn dương
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

public class Bai9 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(2, 5);

        System.out.println("Phân số 1: " + f1);
        System.out.println("Phân số 2: " + f2);
        System.out.println("Cộng: " + f1.add(f2));
        System.out.println("Trừ: " + f1.subtract(f2));
        System.out.println("Nhân: " + f1.multiply(f2));
        System.out.println("Chia: " + f1.divide(f2));
    }
}
