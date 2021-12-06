package StreamsFilesDirectories.exercise;

import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (InputStream in = new FileInputStream(inputPath)){
            int oneByte = in.read();
            int sumVowels = 0;
            int sumConsonants = 0;
            int sumPunctuation = 0;
            while (oneByte >= 0) {
                if ((char) oneByte == 'a' || (char) oneByte == 'e' || (char) oneByte == 'i' || (char) oneByte == 'o' || (char) oneByte == 'u') {
                    sumVowels++;
                } else if ((char) oneByte != '.' && (char) oneByte != ',' && (char) oneByte != '!' && (char) oneByte != '?' && (char) oneByte != ' ' && oneByte != 10 && oneByte != 13) {
                    sumConsonants++;
                } else if ((char) oneByte != ' ' && oneByte != 10 && oneByte != 13) {
                    sumPunctuation++;
                }

                oneByte = in.read();
            }
            System.out.printf("Vowels: %d\n" +
                    "Consonants: %d\n" +
                    "Punctuation: %d\n", sumVowels, sumConsonants, sumPunctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
