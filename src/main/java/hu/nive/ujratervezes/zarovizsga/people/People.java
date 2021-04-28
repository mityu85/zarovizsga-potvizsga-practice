package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        int maleCounter = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                maleCounter = getMaleCounter(maleCounter, line);
            }
            return maleCounter;
        } catch (IOException e) {
            throw new IllegalStateException("File cannot read", e);
        }
    }

    private int getMaleCounter(int maleCounter, String line) {
        if (!line.contains("id,first")) {
            String[] temp = line.split(",");
            if (temp[4].equals("Male")) {
                maleCounter++;
            }
        }
        return maleCounter;
    }
}
