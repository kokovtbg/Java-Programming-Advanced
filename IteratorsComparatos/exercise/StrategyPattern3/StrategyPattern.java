package IteratorsComparatos.exercise.StrategyPattern3;

public class StrategyPattern implements Comparable<StrategyPattern> {
    private String name;
    private int age;

    public StrategyPattern(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(StrategyPattern strategyPattern) {
        if (this.getName().length() == strategyPattern.getName().length()) {
            if (this.getName().toLowerCase().charAt(0) > strategyPattern.getName().toLowerCase().charAt(0)) {
                return 1;
            } else if (this.getName().toLowerCase().charAt(0) < strategyPattern.getName().toLowerCase().charAt(0)) {
                return -1;
            }
            return 0;
        } else {
            return Integer.compare(this.getName().length(), strategyPattern.getName().length());
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
