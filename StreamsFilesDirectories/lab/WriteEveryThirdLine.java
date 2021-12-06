package StreamsFilesDirectories.lab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = in.readLine();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
