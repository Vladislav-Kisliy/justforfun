package vladislav.kisliy.jff.reactor.basic;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class TakeTest {
    @Test
    public void take() {
        int count = 10;
        Flux<Integer> take = range().take(count);
        StepVerifier.create(take).expectNextCount(count).verifyComplete();
    }

    @Test
    public void takeUntil() {
        int count = 50;
        Flux<Integer> take = range().takeUntil(i -> i == (count - 1));
        StepVerifier.create(take).expectNextCount(count).verifyComplete();
    }

    @Test
    public void filter() {
        Flux<Integer> range = Flux.range(0, 1000).take(5);
        Flux<Integer> filter = range.filter(i -> i % 2 == 0);
        StepVerifier.create(filter).expectNext(0, 2, 4).verifyComplete();
    }


    @Test
    public void memory() {
        byte b1 = (byte) 129;
        String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
        System.out.println(s1); // 10000001

        byte b2 = (byte) 2;
        String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 00000010

        b2 = (byte) -2;
        s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 11111110

        b2 = (byte) 3;
        s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 00000011

        b2 = (byte) -3;
        s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 11111101

        b2 = (byte) 1;
        s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 00000001

        b2 = (byte) -1;
        s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 11111111

        b2 = Byte.MAX_VALUE;
        s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 01111111

        b2 = Byte.MIN_VALUE;
        s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2); // 10000000
    }
    private Flux<Integer> range() {
        return Flux.range(0, 1000);
    }

}
