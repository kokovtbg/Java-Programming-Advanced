package IteratorsComparatos.exercise.PetClinics;

import java.util.ArrayDeque;
import java.util.List;

public class Clinic {
    private String name;
    private int rooms;
    private Pet[] pets;
    private ArrayDeque<Integer> queue;
    private int count = 0;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
        this.pets = new Pet[rooms];
        this.queue = new ArrayDeque<>();
        for (int i = 0; i <= this.rooms / 2; i++) {
            this.queue.offer(i);
        }
    }

    public String getName() {
        return name;
    }

    public boolean addPet(List<Pet> pets, String petName) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getName().equals(petName)) {
                Pet pet = pets.get(i);
                if (!this.queue.isEmpty()) {
                    if (count % 2 != 0) {
                        this.pets[this.pets.length / 2 - this.queue.peek()] = pet;
                    } else {
                        this.pets[this.pets.length / 2 + this.queue.poll()] = pet;
                    }
                    count++;
                } else {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        for (int i = this.pets.length / 2; i < this.pets.length; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
        }
        for (int i = 0; i < this.pets.length / 2; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (int i = 0; i < this.pets.length; i++) {
            if (this.pets[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void printClinic() {
        for (int i = 0; i < this.pets.length; i++) {
            if (this.pets[i] != null) {
                System.out.println(pets[i]);
            } else {
                System.out.println("Room empty");
            }
        }
    }

    public void printClinic(int room) {
        System.out.println(this.pets[room]);
    }
}
