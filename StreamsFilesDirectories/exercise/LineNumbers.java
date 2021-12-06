package StreamsFilesDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             OutputStream out = new FileOutputStream(outputPath)){
            String line = reader.readLine();
            int count = 1;
            while (line != null) {
                String numberedLine = count + ". " + line + "\n";
                for (int i = 0; i < numberedLine.length(); i++) {
                    out.write(numberedLine.charAt(i));
                }

                count++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
