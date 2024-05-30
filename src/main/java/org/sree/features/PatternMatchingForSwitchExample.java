package org.sree.features;

public class PatternMatchingForSwitchExample {
    public static void main(String[] args) {
        System.out.println(formatter(1));
        System.out.println(formatter(1654464654654654L));
        System.out.println(formatter(1.0));
        System.out.println(formatter("Sreekanth Gaddoju"));
        testFooBarNew("Bar");
        testStringEnhanced("Y");
        testStringEnhanced("n");
        testStringEnhanced("y");
        testStringEnhanced("N");
        testStringEnhanced("YES");
        testStringEnhanced("NO");
        testStringEnhanced("abc");
        testStringEnhanced(null);
    }

    private static String formatter(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int : %d", i);
            case Long l    -> String.format("long : %d", l);
            case Double d  -> String.format("double : %f", d);
            case String s  -> String.format("String : %s", s);
            default        -> obj.toString();
        };
    }

    private static void testFooBarNew(String s) {
        switch (s) {
            case null         -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok");
        }
    }

    private static void testStringEnhanced(String response) {
        switch (response) {
            case null -> { }
            case "y", "Y" -> System.out.println("You got it");
            case "n", "N" -> System.out.println("Try Again");
            case String s
                    when s.equalsIgnoreCase("YES") -> System.out.println("You got it");
            case String s
                    when s.equalsIgnoreCase("NO") -> System.out.println("Try Again");
            case String s -> System.out.println("Sorry?");
        }
    }
}
