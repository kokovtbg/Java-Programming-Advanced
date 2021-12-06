package StreamsFilesDirectories.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount1 {
    public static void main(String[] args) throws IOException {
        Path pathToWords = Path.of("C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");

        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();
        List<String> allLinesWords = Files.readAllLines(pathToWords);
        allLinesWords.forEach(line -> Arrays.stream(line.split("\\s+")).forEach(word -> wordsCount.put(word, 0)));

        Path pathToText = Path.of("C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> textAllLines = Files.readAllLines(pathToText);
        for (String line : textAllLines) {
            String[] wordsInline = line.split("\\s+");
            Arrays.stream(wordsInline).forEach(word -> {
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            });
        }
        wordsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        PrintWriter writer = new PrintWriter("output.txt");
        wordsCount.entrySet().stream().forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();

    }
}
