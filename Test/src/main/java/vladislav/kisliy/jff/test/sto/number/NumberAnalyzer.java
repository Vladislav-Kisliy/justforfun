package vladislav.kisliy.jff.test.sto.number;

import java.util.Arrays;
import java.util.List;

public class NumberAnalyzer {
    private List<Number> list;

    public NumberAnalyzer(Number[] l) {
        list = Arrays.asList(l);
    }

    public int countOdds() {
        int odd = 0;
        for (Number value : list) {
            if (value.isOdd() == true) {
                odd++;
            }
        }
        return odd;
    }

    public int countEvens() {
        int even = 0;
        for (Number value : list) {
            if (value.isEven() == true) {
                even++;
            }
        }
        return even;
    }

    public int countPerfects() {
        int perfect = 0;
        for (Number value : list) {
            if (value.isPerfect() == true) {
                perfect++;
            }
        }
        return perfect;
    }

    public String toString() {
        return "" + list;
    }

}