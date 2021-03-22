package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {
    public int getNumberOfMales(String s) {
        Path path = Path.of(s);
        String line;
        int maleCounter = 0;
        int femaleCounter = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                if (line.contains(",Male,")) {
                    maleCounter++;
                } else if (line.contains("Female")) {
                    femaleCounter++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
        System.out.println("Male: " + maleCounter + ", Female: " + femaleCounter);
        return maleCounter;
    }
}
