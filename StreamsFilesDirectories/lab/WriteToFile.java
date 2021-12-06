package StreamsFilesDirectories.lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (InputStream in = new FileInputStream(inputPath);
            OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
