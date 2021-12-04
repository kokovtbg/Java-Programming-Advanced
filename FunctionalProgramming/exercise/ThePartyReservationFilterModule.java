package FunctionalProgramming.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));
        String[] names = scan.nextLine().split("\\s+");

        Map<String, Integer> filters = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("Print")) {
            String[] data = command.split(";");
            if (data[0].equals("Add filter")) {
                switch (data[1]) {
                    case "Starts with":
                        for (int i = 0; i < names.length; i++) {
                            if (names[i].startsWith(data[2])) {
                                filters.put("Starts with, " + data[2] + ", " + names[i], i);
                                names[i] = "";
                            }
                        }
                        break;
                    case "Ends with":
                        for (int i = 0; i < names.length; i++) {
                            if (names[i].endsWith(data[2])) {
                                filters.put("Ends with, " + data[2] + ", " + names[i], i);
                                names[i] = "";
                            }
                        }
                        break;
                    case "Length":
                        for (int i = 0; i < names.length; i++) {
                            if (names[i].length() == Integer.parseInt(data[2])) {
                                filters.put("Length, " + data[2] + ", " + names[i], i);
                                names[i] = "";
                            }
                        }
                        break;
                    case "Contains":
                        for (int i = 0; i < names.length; i++) {
                            if (names[i].contains(data[2])) {
                                filters.put("Contains, " + data[2] + ", " + names[i], i);
                                names[i] = "";
                            }
                        }
                        break;
                }
            } else if (data[0].equals("Remove filter")) {
                switch (data[1]) {
                    case "Starts with":
                        for (Map.Entry<String, Integer> entry : filters.entrySet()) {
                            if (entry.getKey().startsWith("Starts with")) {
                                String[] splitData = entry.getKey().split(", ");
                                if (splitData[1].equals(data[2])) {
                                    names[entry.getValue()] = splitData[2];
                                }
                            }
                        }
                        break;
                    case "Ends with":
                        for (Map.Entry<String, Integer> entry : filters.entrySet()) {
                            if (entry.getKey().startsWith("Ends with")) {
                                String[] splitData = entry.getKey().split(", ");
                                if (splitData[1].equals(data[2])) {
                                    names[entry.getValue()] = splitData[2];
                                }
                            }
                        }
                        break;
                    case "Length":
                        for (Map.Entry<String, Integer> entry : filters.entrySet()) {
                            if (entry.getKey().startsWith("Length")) {
                                String[] splitData = entry.getKey().split(", ");
                                if (splitData[1].equals(data[2])) {
                                    names[entry.getValue()] = splitData[2];
                                }
                            }
                        }
                        break;
                    case "Contains":
                        for (Map.Entry<String, Integer> entry : filters.entrySet()) {
                            if (entry.getKey().startsWith("Contains")) {
                                String[] splitData = entry.getKey().split(", ");
                                if (splitData[1].equals(data[2])) {
                                    names[entry.getValue()] = splitData[2];
                                }
                            }
                        }
                        break;
                }
            }

            command = scan.nextLine();
        }
        for (String name : names) {
            if (!name.equals("")) {
                writer.write(name + " ");
            }
        }
        writer.flush();
    }
}
