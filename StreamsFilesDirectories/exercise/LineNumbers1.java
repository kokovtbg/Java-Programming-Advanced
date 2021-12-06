package StreamsFilesDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("output.txt");
        int countRow = 1;
        for (String line : allLines) {
            writer.write(countRow + ". " + line + "\n");
            countRow++;
        }
        writer.close();
    }
}
