package StreamsFilesDirectories.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles1 {
    public static void main(String[] args) throws IOException {
        String pathOne = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwo = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        List<String> allLinesFirstFile = Files.readAllLines(Path.of(pathOne));
        List<String> allLinesSecondFile = Files.readAllLines(Path.of(pathTwo));

        PrintWriter writer = new PrintWriter("output.txt");
        allLinesFirstFile.forEach(writer::println);
        allLinesSecondFile.forEach(writer::println);

        writer.close();
    }
}
