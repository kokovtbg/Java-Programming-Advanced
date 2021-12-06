package StreamsFilesDirectories.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

        Files.readAllLines(Path.of(path)).forEach(line -> {
            try {
                writer.write(line.toUpperCase());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }
}
