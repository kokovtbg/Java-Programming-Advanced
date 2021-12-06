package StreamsFilesDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String inputPathWords = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputPathText = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPathWords));
             BufferedReader reader1 = Files.newBufferedReader(Paths.get(inputPathText));
             OutputStream out = new FileOutputStream(outputPath)){
            List<String> words = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
            Map<String, Integer> wordsCount = new LinkedHashMap<>();
            for (int i = 0; i < words.size(); i++) {
                wordsCount.put(words.get(i), 0);
            }
            String line = reader1.readLine();
            while (line != null) {
                String[] wordsInLine = line.split("\\s+");
                for (int i = 0; i < wordsInLine.length; i++) {
                    if (wordsCount.containsKey(wordsInLine[i])) {
                        wordsCount.put(wordsInLine[i], wordsCount.get(wordsInLine[i]) + 1);
                    }
                }

                line = reader1.readLine();
            }
            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                String thingToWrite = entry.getKey() + " - " + entry.getValue() + "\n";
                for (int i = 0; i < thingToWrite.length(); i++) {
                    out.write(thingToWrite.charAt(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
