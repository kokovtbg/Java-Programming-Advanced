package DefiningClasses.exercise.FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        PersonFamilyTree person;
        if (!input.contains("/")) {
            String[] data = input.split("\\s+");
            String firstname = data[0];
            String lastname = data[1];
            person = new PersonFamilyTree(firstname, lastname);
        } else {
            person = new PersonFamilyTree(input);
        }
        String command = scan.nextLine();
        List<Parents> parents = new ArrayList<>();
        List<Children> children = new ArrayList<>();
        while (!command.equals("End")) {
            if (command.contains("-")) {
                String[] data = command.split("\\s+-\\s+");
                if (!data[0].contains("/")) {
                    String firstname = data[0].split("\\s+")[0];
                    String lastname = data[0].split("\\s+")[1];
                    Parents parent = new Parents(firstname, lastname);
                    parents.add(parent);
                    if (!data[1].contains("/")) {
                        String firstnameChild = data[1].split("\\s+")[0];
                        String lastnameChild = data[1].split("\\s+")[1];
                        Children child = new Children(firstnameChild, lastnameChild);
                        children.add(child);
                    } else {
                        String birthdayChild = data[1];
                        Children child = new Children(birthdayChild);
                        children.add(child);
                    }
                } else {
                    String birthday = data[0];
                    Parents parent = new Parents(birthday);
                    parents.add(parent);
                    if (!data[1].contains("/")) {
                        String firstnameChild = data[1].split("\\s+")[0];
                        String lastnameChild = data[1].split("\\s+")[1];
                        Children child = new Children(firstnameChild, lastnameChild);
                        children.add(child);
                    } else {
                        String birthdayChild = data[1];
                        Children child = new Children(birthdayChild);
                        children.add(child);
                    }
                }
            } else {
                String[] data = command.split("\\s+");
                String firstname = data[0];
                String lastname = data[1];
                String date = data[2];
                if (firstname.equals(person.getFirstname()) && lastname.equals(person.getLastname())) {
                    person.setBirthday(date);
                } else if (date.equals(person.getBirthday())) {
                    person.setFirstname(firstname);
                    person.setLastname(lastname);
                }
                for (int i = 0; i < parents.size(); i++) {
                    if (parents.get(i).getFirstname() != null && parents.get(i).getFirstname().equals(firstname) && parents.get(i).getLastname().equals(lastname)) {
                        parents.get(i).setBirthday(date);
                    } else if (parents.get(i).getBirthday() != null && parents.get(i).getBirthday().equals(date)) {
                        parents.get(i).setFirstname(firstname);
                        parents.get(i).setLastname(lastname);
                    }
                }
                for (int i = 0; i < children.size(); i++) {
                    if (children.get(i).getFirstname() != null && children.get(i).getFirstname().equals(firstname) && children.get(i).getLastname().equals(lastname)) {
                        children.get(i).setBirthday(date);
                    } else if (children.get(i).getBirthday() != null && children.get(i).getBirthday().equals(date)) {
                        children.get(i).setFirstname(firstname);
                        children.get(i).setLastname(lastname);
                    }
                }

            }

            command = scan.nextLine();
        }
        for (int i = 0; i < parents.size(); i++) {
            if (parents.get(i).getFirstname() != null && person.getFirstname() != null && parents.get(i).getFirstname().equals(person.getFirstname()) && parents.get(i).getLastname().equals(person.getLastname())) {
                PersonFamilyTree.Children child;
                if (children.get(i).getFirstname() != null && children.get(i).getBirthday() != null) {
                    child = new PersonFamilyTree.Children(children.get(i).getFirstname(), children.get(i).getLastname());
                    child.setBirthday(children.get(i).getBirthday());
                } else if (parents.get(i).getFirstname() != null) {
                    child = new PersonFamilyTree.Children(children.get(i).getFirstname(), children.get(i).getLastname());
                } else {
                    child = new PersonFamilyTree.Children(children.get(i).getBirthday());
                }
//                PersonFamilyTree.Children child = new PersonFamilyTree.Children(children.get(i).getFirstname(), children.get(i).getLastname());
//                child.setBirthday(children.get(i).getBirthday());
                person.getChildren().add(child);
            } else if (children.get(i).getFirstname() != null && person.getFirstname() != null && children.get(i).getFirstname().equals(person.getFirstname()) && children.get(i).getLastname().equals(person.getLastname())) {
                PersonFamilyTree.Parents parent;
                if (parents.get(i).getFirstname() != null && parents.get(i).getBirthday() != null) {
                    parent = new PersonFamilyTree.Parents(parents.get(i).getFirstname(), parents.get(i).getLastname());
                    parent.setBirthday(parents.get(i).getBirthday());
                } else if (parents.get(i).getFirstname() != null) {
                    parent = new PersonFamilyTree.Parents(parents.get(i).getFirstname(), parents.get(i).getLastname());
                } else {
                    parent = new PersonFamilyTree.Parents(parents.get(i).getBirthday());
                }
//                PersonFamilyTree.Parents parent = new PersonFamilyTree.Parents(parents.get(i).getFirstname(), parents.get(i).getLastname());
//                parent.setBirthday(parents.get(i).getBirthday());
                person.getParents().add(parent);
            }
        }
        System.out.println(person);
        System.out.println("Parents:");
        for (int i = 0; i < person.getParents().size(); i++) {
            System.out.println(person.getParents().get(i));
        }
        System.out.println("Children:");
        for (int i = 0; i < person.getChildren().size(); i++) {
            System.out.println(person.getChildren().get(i));
        }
    }
}
