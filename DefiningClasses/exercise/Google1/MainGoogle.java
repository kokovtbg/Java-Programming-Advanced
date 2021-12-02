package DefiningClasses.exercise.Google1;

import java.util.*;

public class MainGoogle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Google.Person> people = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            switch (data[1]) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Google.Person.Company company = new Google.Person.Company(companyName, department, salary);
                    boolean personExist = false;
                    for (Google.Person person : people) {
                        if (person.getName().equals(name)) {
                            person.setCompany(company);
                            personExist = true;
                        }
                    }
                    if (!personExist) {
                        Google.Person person = new Google.Person(name, company);
                        people.add(person);
                    }
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Google.Person.Pokemon pokemon = new Google.Person.Pokemon(pokemonName, pokemonType);
                    boolean personExist1 = false;
                    for (Google.Person person1 : people) {
                        if (person1.getName().equals(name)) {
                            List<Google.Person.Pokemon> pokemons;
                            if (person1.getPokemons() != null) {
                                pokemons = person1.getPokemons();
                            } else {
                                pokemons = new ArrayList<>();
                            }
                            pokemons.add(pokemon);
                            person1.setPokemons(pokemons);
                            personExist1 = true;
                        }
                    }
                    if (!personExist1) {
                        List<Google.Person.Pokemon> pokemons = new ArrayList<>();
                        pokemons.add(pokemon);
                        Google.Person person1 = new Google.Person(name, pokemons);
                        people.add(person1);
                    }
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Google.Person.Parents parent = new Google.Person.Parents(parentName, parentBirthday);
                    boolean personExist2 = false;
                    for (Google.Person person1 : people) {
                        if (person1.getName().equals(name)) {
                            LinkedHashSet<Google.Person.Parents> parents;
                            if (person1.getParents() != null) {
                                parents = person1.getParents();
                            } else {
                                parents = new LinkedHashSet<>();
                            }
                            parents.add(parent);
                            person1.setParents(parents);
                            personExist2 = true;
                        }
                    }
                    if (!personExist2) {
                        LinkedHashSet<Google.Person.Parents> parents = new LinkedHashSet<>();
                        parents.add(parent);
                        Google.Person person1 = new Google.Person(name, parents);
                        people.add(person1);
                    }
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Google.Person.Children child = new Google.Person.Children(childName, childBirthday);
                    boolean personExist3 = false;
                    for (Google.Person person1 : people) {
                        if (person1.getName().equals(name)) {
                            ArrayDeque<Google.Person.Children> children;
                            if (person1.getChildren() != null) {
                                children = person1.getChildren();
                            } else {
                                children = new ArrayDeque<>();
                            }
                            children.add(child);
                            person1.setChildren(children);
                            personExist3 = true;
                        }
                    }
                    if (!personExist3) {
                        ArrayDeque<Google.Person.Children> children = new ArrayDeque<>();
                        children.add(child);
                        Google.Person person1 = new Google.Person(name, children);
                        people.add(person1);
                    }
                    break;
                default:
                    String carModel = data[2];
                    String carSpeed = data[3];
                    Google.Person.Car car = new Google.Person.Car(carModel, carSpeed);
                    boolean personExist4 = false;
                    for (Google.Person person : people) {
                        if (person.getName().equals(name)) {
                            person.setCar(car);
                            personExist4 = true;
                        }
                    }
                    if (!personExist4) {
                        Google.Person person1 = new Google.Person(name, car);
                        people.add(person1);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        String name = scan.nextLine();
        for (Google.Person person : people) {
            if (person.getName().equals(name)) {
                System.out.println(person.getName());
                System.out.printf("Company:%n");
                if (person.getCompany() != null) {
                    System.out.println(person.getCompany());
                }
                System.out.printf("Car:%n");
                if (person.getCar() != null) {
                    System.out.println(person.getCar());
                }
                System.out.printf("Pokemon:%n");
                if (person.getPokemons() != null) {
                    for (Google.Person.Pokemon pokemon : person.getPokemons()) {
                        System.out.println(pokemon);
                    }
                }
                System.out.printf("Parents:%n");
                if (person.getParents() != null) {
                    for (Google.Person.Parents parent : person.getParents()) {
                        System.out.println(parent);
                    }
                }
                System.out.printf("Children:%n");
                if (person.getChildren() != null) {
                    for (Google.Person.Children child : person.getChildren()) {
                        System.out.println(child);
                    }
                }
            }
        }
    }
}
