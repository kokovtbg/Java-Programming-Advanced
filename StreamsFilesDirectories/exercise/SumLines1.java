package StreamsFilesDirectories.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SumLines1 {
    public static void main(String[] args) throws IOException {
        String pathStr = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Path path = Path.of(pathStr);
        List<String> allLines = Files.readAllLines(path);
        //1 начин
        allLines.stream().map(String::toCharArray).forEach(charArray -> {
            int sum = 0;
            for (char symbol : charArray) {
                sum += symbol;
            }
            System.out.println(sum);
        });
        //2 начин
//        for (String line : allLines) {
//            int sum = 0;
//            for (int i = 0; i < line.length(); i++) {
//                sum += line.charAt(i);
//            }
//            System.out.println(sum);
//        }
    }
}
