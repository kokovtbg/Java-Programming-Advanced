package StreamsFilesDirectories.lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        Scanner scan = new Scanner(new FileInputStream(inputPath));
        PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                out.println(scan.nextInt());
            }
            scan.next();
        }
        out.close();
    }
}
