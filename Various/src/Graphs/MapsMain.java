package Graphs;

import java.util.HashMap;
import java.util.Iterator;

public class MapsMain {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap();

        map.put(1, "Noah");
        map.put(2, "Eric");
        map.put(3,"Sam");
        map.put(14, "Bob");
        map.put(4, "Antong");
        map.put(10, "Isaac");
        map.put(6, "Devin");
        map.put(1, "Luke");

        for(int key: map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }

        if(map.containsKey(4)) {
            System.out.println("4 is in the map");
        }

        //Using an iterator!!!!!!!!!
        //Can iterate over values if want to
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            int key = iterator.next();
            String value = map.get(key);
            System.out.println(value);
        }


        //removing from a map:
        if(map.containsKey(1)) {
            map.remove(1);
        }
        for(int key: map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }

    }
}
