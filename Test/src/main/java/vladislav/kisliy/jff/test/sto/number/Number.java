package vladislav.kisliy.jff.test.sto.number;

public class Number {
    private Integer number;

    public Number(int n) {
        number = n;
    }

    public boolean isEven() {
        if (number % 2 == 0)
            return true;
        else
            return false;
    }

    public boolean isOdd() {
        if (number % 2 != 0)
            return true;
        else
            return false;
    }

    public boolean isPerfect() {
        int count = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                count += i;
        }
        if (number == count) {
            return true;
        } else
            return false;
    }

    public String toString() {
        return "" + number;
    }
}