package StreamsFilesDirectories.lab;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output1.txt";

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }

                oneByte = in.read();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
