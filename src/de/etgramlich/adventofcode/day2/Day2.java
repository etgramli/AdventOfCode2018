package de.etgramlich.adventofcode.day2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Day2 {
    private Day2() {}

    public static long checksum(final List<String> lines) {
        final long classTwos = lines.stream().filter(Day2::isClassTwo).count();
        final long classThrees = lines.stream().filter(Day2::isClassThree).count();

        return classTwos * classThrees;
    }

    private static boolean isClassTwo(final String str) {
        return str.chars().boxed()
                .collect(Collectors.groupingBy(integer -> integer, Collectors.counting())).containsValue(2L);
    }

    private static boolean isClassThree(final String str) {
        return str.chars().boxed()
                .collect(Collectors.groupingBy(integer -> integer, Collectors.counting())).containsValue(3L);
    }


    public static List<Character> getWordsDifferentInOneLetter(final Collection<String> words) {
        for (String word : words) {
            for (String other : words) {
                if (editDistanceHemdsärmlig(word, other) == 1) {
                    return toSet(word).stream().filter(c -> toSet(other).contains(c)).collect(Collectors.toList());
                }
            }
        }
        return Collections.emptyList();
    }

    private static int editDistanceHemdsärmlig(final String first, final String second) {
        long numDifferentLetters = IntStream.range(0, first.length())
                .mapToObj(i -> first.charAt(i) != second.charAt(i)).filter(s -> s).count();
        return Math.toIntExact(numDifferentLetters);
    }

    private static List<Character> toSet(final String str) {
        List<Character> chars = new ArrayList<>(str.length());
        for (Character c : str.toCharArray()) {
            chars.add(c);
        }
        return Collections.unmodifiableList(chars);
    }
}
