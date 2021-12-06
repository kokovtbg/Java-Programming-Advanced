package StreamsFilesDirectories.exercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Software University\\Java Developing\\Programming Advanced\\04. Java-Advanced-Streams-Files-and-Directories-Resources-exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);
        int size = 0;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    size += f.length();
                }
            }
        }
        System.out.println("Folder size: " + size);
    }
}
