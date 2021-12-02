package DefiningClasses.exercise.Google1;

import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.List;

public class Google {
    public static class Person {
        public static class Company {
            private String companyName;
            private String department;
            private double salary;

            public Company(String companyName, String department, double salary) {
                this.companyName = companyName;
                this.department = department;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return String.format("%s %s %.2f", this.companyName, this.department, this.salary);
            }
        }
        public static class Pokemon {
            private String pokemonName;
            private String  pokemonType;

            public Pokemon(String pokemonName, String pokemonType) {
                this.pokemonName = pokemonName;
                this.pokemonType = pokemonType;
            }

            @Override
            public String toString() {
                return String.format("%s %s", this.pokemonName, this.pokemonType);
            }
        }
        public static class Parents {
            private String parentName;
            private String parentBirthday;

            public Parents(String parentName, String parentBirthday) {
                this.parentName = parentName;
                this.parentBirthday = parentBirthday;
            }

            @Override
            public String toString() {
                return String.format("%s %s", this.parentName, this.parentBirthday);
            }
        }
        public static class Children {
            private String childName;
            private String childBirthday;

            public Children(String childName, String childBirthday) {
                this.childName = childName;
                this.childBirthday = childBirthday;
            }

            @Override
            public String toString() {
                return String.format("%s %s", this.childName, this.childBirthday);
            }
        }
        public static class Car {
            private String carModel;
            private String carSpeed;

            public Car(String carModel, String carSpeed) {
                this.carModel = carModel;
                this.carSpeed = carSpeed;
            }

            @Override
            public String toString() {
                return String.format("%s %s", this.carModel, this.carSpeed);
            }
        }
        private String name;
        private Company company;
        private List<Pokemon> pokemons;
        private LinkedHashSet<Parents> parents;
        private ArrayDeque<Children> children;
        private Car car;

        public Person(String name, Company company, List<Pokemon> pokemons, LinkedHashSet<Parents> parents, ArrayDeque<Children> children, Car car) {
            this.name = name;
            this.company = company;
            this.pokemons = pokemons;
            this.parents = parents;
            this.children = children;
            this.car = car;
        }

        public Person(String name, Company company) {
            this.name = name;
            this.company = company;
        }

        public Person(String name, List<Pokemon> pokemons) {
            this.name = name;
            this.pokemons = pokemons;
        }

        public Person(String name, LinkedHashSet<Parents> parents) {
            this.name = name;
            this.parents = parents;
        }

        public Person(String name, ArrayDeque<Children> children) {
            this.name = name;
            this.children = children;
        }

        public Person(String name, Car car) {
            this.name = name;
            this.car = car;
        }

        public String getName() {
            return name;
        }

        public List<Pokemon> getPokemons() {
            return pokemons;
        }

        public LinkedHashSet<Parents> getParents() {
            return parents;
        }

        public ArrayDeque<Children> getChildren() {
            return children;
        }

        public Company getCompany() {
            return company;
        }

        public Car getCar() {
            return car;
        }

        public void setPokemons(List<Pokemon> pokemons) {
            this.pokemons = pokemons;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public void setParents(LinkedHashSet<Parents> parents) {
            this.parents = parents;
        }

        public void setChildren(ArrayDeque<Children> children) {
            this.children = children;
        }

        public void setCar(Car car) {
            this.car = car;
        }
    }
}
