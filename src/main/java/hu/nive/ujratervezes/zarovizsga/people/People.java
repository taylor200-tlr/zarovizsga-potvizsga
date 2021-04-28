package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class People {
    private List<String> males = new ArrayList<>();

    public int getNumberOfMales(String s) {
        Path path = Path.of(s);
        String line;
        int maleCounter = 0;
        int femaleCounter = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                if (line.contains(",Male,")) {
                    maleCounter++;
                    males.add(line);
                } else if (line.contains("Female")) {
                    femaleCounter++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
        System.out.println("Male: " + maleCounter + ", Female: " + femaleCounter);
        writePeople(s);
        return maleCounter;
    }

    public void writePeople(String path) {
        String newPath = path.replace("people.csv", "malelist.txt");
        Path file = Path.of(newPath);
        try {
            Files.write(file, males);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
