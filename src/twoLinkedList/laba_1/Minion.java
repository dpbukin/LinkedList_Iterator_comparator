package twoLinkedList.laba_1;

import java.util.Comparator;

public class Minion {
    private String name;
    private int numberOfEyes;
    private int age;
    private String color;

    public Minion(String name, int numberOfEyes, int age, String color) {
        this.name = name;
        this.numberOfEyes = numberOfEyes;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public void setNumberOfEyes(int numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", numberOfEyes=" + numberOfEyes +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public static class AgeComparator implements Comparator<Minion> {
        @Override
        public int compare(Minion minion1, Minion minion2) {
            return Integer.compare(minion1.getAge(), minion2.getAge());
        }
    }

    public static class NameComparator implements Comparator<Minion> {
        @Override
        public int compare(Minion minion1, Minion minion2) {
            return minion1.getName().compareTo(minion2.getName());
        }
    }

    public static class EyesComparator implements Comparator<Minion> {
        @Override
        public int compare(Minion minion1, Minion minion2) {
            return Integer.compare(minion1.getNumberOfEyes(), minion2.getNumberOfEyes());
        }
    }

    public static class MixComparator implements Comparator<Minion> {
        @Override
        public int compare(Minion minion1, Minion minion2) {
            int result = Integer.compare(minion1.getNumberOfEyes(), minion2.getNumberOfEyes());
            if (result == 0) {
                result = minion1.getName().compareTo(minion2.getName());
                if (result == 0) {
                    result = Integer.compare(minion1.getAge(), minion2.getAge());
                }
            }
            return result;
        }
    }

    public static class ColorComparator implements Comparator<Minion> {
        @Override
        public int compare(Minion minion1, Minion minion2) {
            return minion2.getColor().compareTo(minion1.getColor());
        }
    }



}
