package ru.nikita.utils;

import javax.inject.Singleton;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.IntStream;

@Singleton
public class IdGenerator {
    public static final String UNMISTAKABLE_CHARS = "23456789ABCDEFGHJKLMNPQRSTWXYZabcdefghijkmnopqrstuvwxyz";
    public static final String BASE64_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";

    protected int charsCount() {
        return 17;
    }

    private char choice(CharSequence chars) {
        final double index = Math.floor(Math.random() * chars.length());
        return chars.charAt((int) index);
    }

    private BiFunction<Integer, CharSequence, String> random = (count, alphabet) -> IntStream.range(0, count)
            .mapToObj(it -> this.choice(alphabet))
            .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));

    public String id() {
        return random.apply(charsCount(), UNMISTAKABLE_CHARS);
    }

    public String number(int count) {
        return random.apply(count, "0123456789");
    }

    public String secret() {
        return random.apply(charsCount(), BASE64_CHARS);
    }

    public String hexString(int digits) {
        return random.apply(digits, "0123456789abcdef");
    }
}
