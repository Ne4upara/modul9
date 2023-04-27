package ua.goit.sergey.modul9;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {

        MyHashMap<Integer, Integer> i = new MyHashMap<>();

        i.put(1, 10);
        i.put(2, 20);
        i.put(3, 30);
        i.put(2,2000);

        System.out.println("i.get(2) = " + i.get(2));

        i.remove(3);

        System.out.println("i.size() = " + i.size());

        i.clear();

        System.out.println("i.size() clear = " + i.size());

        System.out.println("i = " + i);

    }
}

