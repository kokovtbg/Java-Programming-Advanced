package StreamsFilesDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String path = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))){
            String line = reader.readLine();
            while (line != null) { 
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);

                line = reader.readLine();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
