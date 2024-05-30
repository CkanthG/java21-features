package org.sree.features;

public class RecordPatternsExample {

    record Person(Object x, Object y){}

    public static void main(String[] args) {
        Person p = new Person("sree", 32);
        recordPatterns(p);
    }

    private static void recordPatterns(Person p) {
        if (p instanceof Person(String x, Integer y)) {
            System.out.println(STR."Person Name : \{x} & Age : \{y}");
        } else {
            System.out.println("No Person Exist");
        }
    }
}
