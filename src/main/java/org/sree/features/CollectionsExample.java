package org.sree.features;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        sequenceCollections();
        sequentialMapCollections();
    }

    private static void sequenceCollections() {
        SequencedCollection<String> sequencedCollection = new ArrayList<>();
        sequencedCollection.add("abc");
        sequencedCollection.add("def");
        sequencedCollection.add("ghi");
        sequencedCollection.add("jkl");
        sequencedCollection.add("mno");
        System.out.println(sequencedCollection.getFirst());
        System.out.println(sequencedCollection.getLast());
        System.out.println(sequencedCollection.reversed());
        System.out.println(sequencedCollection.removeFirst());
        System.out.println(sequencedCollection.removeLast());
        System.out.println(sequencedCollection);
    }

    private static void sequentialMapCollections() {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put(1, "abc");
        sequencedMap.put(2, "def");
        sequencedMap.put(4, "jkl");
        sequencedMap.put(5, "mno");
        sequencedMap.put(3, "ghi");
        System.out.println(sequencedMap.firstEntry());
        System.out.println(sequencedMap.lastEntry());
        System.out.println(sequencedMap.reversed());
        System.out.println(sequencedMap.sequencedKeySet());
        System.out.println(sequencedMap.sequencedValues());
        sequencedMap.putFirst(0, "aaa");
        sequencedMap.putLast(6, "zzz");
        System.out.println(sequencedMap);
        System.out.println(sequencedMap.pollFirstEntry());
        System.out.println(sequencedMap.pollLastEntry());
        System.out.println(sequencedMap);
    }
}
