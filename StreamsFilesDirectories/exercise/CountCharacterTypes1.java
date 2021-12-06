package StreamsFilesDirectories.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;
        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i' || currentSymbol == 'o' || currentSymbol == 'u') {
                    countVowels++;
                } else if (currentSymbol == '.' || currentSymbol == ',' || currentSymbol == '!' || currentSymbol == '?') {
                    countPunctuation++;
                } else {
                    countConsonants++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("Vowels " + countVowels);
        writer.newLine();
        writer.write("Consonants " + countConsonants);
        writer.newLine();
        writer.write("Punctuation " + countPunctuation);
        writer.close();
    }
}
