package StreamsFilesDirectories.exercise;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SumBytes {
    public static void main(String[] args) {
        String path = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (InputStream in = new FileInputStream(path)){
          int oneByte = in.read();
          long sum = 0;
          while (oneByte >= 0) {
              if (oneByte != 10 && oneByte != 13) {
                  sum += oneByte;
              }

              oneByte = in.read();
          }
          System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
