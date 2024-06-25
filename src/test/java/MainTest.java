import org.example.Main;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MainTest {

    @ParameterizedTest
    @MethodSource("provideGetListOfPairs")
    public void testGetListOfPairs(String input, List<String> expected) {
        List<String> result = Main.getListOfPairs(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideGetListOfPairs() {
        return Stream.of(
                Arguments.of("ab", List.of("ab")),
                Arguments.of("abc", List.of("ab", "bc")),
                Arguments.of("abcd", List.of("ab", "bc", "cd"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetCombinations")
    public void testGetCombinations(int length, List<String> expected) {
        List<String> result = Main.getCombinations(length);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideGetCombinations() {
        return Stream.of(
                Arguments.of(1, List.of("0", "1")),
                Arguments.of(2, List.of("00", "01", "10", "11")),
                Arguments.of(3, List.of("000", "001", "010", "011", "100", "101", "110", "111"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetResultString")
    public void testGetResultString(String combination, List<String> pairs, String expected) {
        String result = Main.getResultString(combination, pairs);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideGetResultString() {
        return Stream.of(
                Arguments.of("00", List.of("ab", "bc"), "abc"),
                Arguments.of("01", List.of("ab", "bc"), "ab.c"),
                Arguments.of("10", List.of("ab", "bc"), "a.bc"),
                Arguments.of("11", List.of("ab", "bc"), "a.b.c"),
                Arguments.of("000", List.of("ab", "bc", "cd"), "abcd"),
                Arguments.of("001", List.of("ab", "bc", "cd"), "abc.d"),
                Arguments.of("010", List.of("ab", "bc", "cd"), "ab.cd"),
                Arguments.of("011", List.of("ab", "bc", "cd"), "ab.c.d"),
                Arguments.of("100", List.of("ab", "bc", "cd"), "a.bcd"),
                Arguments.of("101", List.of("ab", "bc", "cd"), "a.bc.d"),
                Arguments.of("110", List.of("ab", "bc", "cd"), "a.b.cd"),
                Arguments.of("111", List.of("ab", "bc", "cd"), "a.b.c.d")
        );
    }

    @ParameterizedTest
    @MethodSource("provideConvertToBinary")
    public void testConvertToBinary(int bits, int number, String expected) {
        String result = Main.convertToBinary(bits, number);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideConvertToBinary() {
        return Stream.of(
                Arguments.of(1, 0, "0"),
                Arguments.of(1, 1, "1"),
                Arguments.of(2, 0, "00"),
                Arguments.of(2, 1, "01"),
                Arguments.of(2, 2, "10"),
                Arguments.of(2, 3, "11"),
                Arguments.of(3, 0, "000"),
                Arguments.of(3, 1, "001"),
                Arguments.of(3, 2, "010"),
                Arguments.of(3, 3, "011"),
                Arguments.of(3, 4, "100"),
                Arguments.of(3, 5, "101"),
                Arguments.of(3, 6, "110"),
                Arguments.of(3, 7, "111")
        );
    }
}