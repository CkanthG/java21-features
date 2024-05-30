package org.sree.features;

public class StringTemplateExample {

    public static void main(String[] args) {
        System.out.println(buildStringTemplate("str", "val"));
    }

    private static String buildStringTemplate(String key, String value) {
        return STR."This is string template using key:\{key} and value:\{value}";
    }
}
