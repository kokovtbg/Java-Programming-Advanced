package StreamsFilesDirectories.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path outputPath = Paths.get("C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");

        try {
            List<String> lines = Files.readAllLines(inputPath);
            lines = lines.stream().filter(l -> !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(outputPath, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
