package vladislav.kisliy.jff.test.sto.number;

import static java.lang.System.*;

public class Runner {
    public static void main(String args[]) {
        Number[] r = {new Number(5), new Number(12), new Number(9), new Number(6),
                new Number(1), new Number(4), new Number(8), new Number(6)};
        NumberAnalyzer test = new NumberAnalyzer(r);
        out.println(test);
        out.println("odd count = " + test.countOdds());
        out.println("even count = " + test.countEvens());
        out.println("perfect count = " + test.countPerfects() + "\n\n\n");


    }
}
