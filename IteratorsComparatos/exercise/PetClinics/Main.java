package IteratorsComparatos.exercise.PetClinics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String command = data[0];
            if (command.equals("Create")) {
                if (data[1].equals("Pet")) {
                    Pet pet = new Pet(data[2], Integer.parseInt(data[3]), data[4]);
                    pets.add(pet);
                } else if (data[1].equals("Clinic")) {
                    int rooms = Integer.parseInt(data[3]);
                    if (rooms % 2 != 0) {
                        Clinic clinic = new Clinic(data[2], rooms);
                        clinics.add(clinic);
                    } else {
                        System.out.println("Invalid Operation!");
                    }
                }
            } else if (command.equals("Add")) {
                String petName = data[1];
                String clinicName = data[2];
                Clinic clinic = null;
                for (int j = 0; j < clinics.size(); j++) {
                    if (clinics.get(j).getName().equals(clinicName)) {
                        clinic = clinics.get(j);
                        break;
                    }
                }
                System.out.println(clinic.addPet(pets, petName));
            } else if (command.equals("Release")) {
                String clinicName = data[1];
                Clinic clinic = null;
                for (int j = 0; j < clinics.size(); j++) {
                    if (clinics.get(j).getName().equals(clinicName)) {
                        clinic = clinics.get(j);
                        break;
                    }
                }
                System.out.println(clinic.release());
            } else if (command.equals("HasEmptyRooms")) {
                String clinicName = data[1];
                Clinic clinic = null;
                for (int j = 0; j < clinics.size(); j++) {
                    if (clinics.get(j).getName().equals(clinicName)) {
                        clinic = clinics.get(j);
                        break;
                    }
                }
                System.out.println(clinic.hasEmptyRooms());
            } else if (command.equals("Print")) {
                String clinicName = data[1];
                Clinic clinic = null;
                for (int j = 0; j < clinics.size(); j++) {
                    if (clinics.get(j).getName().equals(clinicName)) {
                        clinic = clinics.get(j);
                        break;
                    }
                }
                if (data.length == 2) {
                    clinic.printClinic();
                } else {
                    int room = Integer.parseInt(data[2]);
                    clinic.printClinic(room - 1);
                }
            }
        }
    }
}
