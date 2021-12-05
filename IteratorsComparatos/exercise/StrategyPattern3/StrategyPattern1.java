package IteratorsComparatos.exercise.StrategyPattern3;

public class StrategyPattern1 implements Comparable<StrategyPattern1> {
    private String name;
    private int age;

    public StrategyPattern1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(StrategyPattern1 strategyPattern1) {
        return Integer.compare(this.age, strategyPattern1.getAge());
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
