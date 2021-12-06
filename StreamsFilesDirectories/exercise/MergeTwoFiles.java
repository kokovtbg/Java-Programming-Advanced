package StreamsFilesDirectories.exercise;

import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputPath2 = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (InputStream in1 = new FileInputStream(inputPath);
             InputStream in2 = new FileInputStream(inputPath2);
             OutputStream out = new FileOutputStream(outputPath)){
            int character1 = in1.read();
            while (character1 >= 0) {
                out.write(character1);

                character1 = in1.read();
            }
            out.write(10);
            int character2 = in2.read();
            while (character2 >= 0) {
                out.write(character2);

                character2 = in2.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
