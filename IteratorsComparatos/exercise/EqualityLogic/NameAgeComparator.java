package IteratorsComparatos.exercise.EqualityLogic;

import java.util.Comparator;

public class NameAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getName().equals(person2.getName())) {
            if (person1.getAge() == person2.getAge()) {
                return 0;
            } else {
                return Integer.compare(person1.getAge(), person2.getAge());
            }
        } else {
            return person1.getName().compareTo(person2.getName());
        }
    }
}
