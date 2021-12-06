package StreamsFilesDirectories.exercise;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                if (oneByte >= 97 && oneByte <= 122) {
                    oneByte -= 32;
                }
                out.write(oneByte);

                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
