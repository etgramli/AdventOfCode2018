package de.etgramlich.adventofcode.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public final class Main {
    public static void main(String[] args) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get("boxIDs.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Checksum: " + Day2.checksum(lines));
        List<Character> list = Day2.getWordsDifferentInOneLetter(lines);
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        if (sb.toString().equals("megsdlpulxvinkatfoyzxcbvq")) {
            System.out.println("Common letters: " + sb.toString());
        } else {
            System.err.println("Error introduced!!!");
        }
    }
}
