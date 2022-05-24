package IterationStation;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Ramen> ramenList = new ArrayList();
        for(int i = 0; i < 10; i++) {
            ramenList.add(new Ramen());
        }
        printArrayList(ramenList);
        removeAllVolume(ramenList,3);
        System.out.println();
        printArrayList(ramenList);


    }

    public static void printArrayList(ArrayList<Ramen> arr) {
        ListIterator<Ramen> iter = arr.listIterator();
        while(iter.hasNext()) {
            Ramen r = iter.next();
            System.out.println(r);
        }
    }

    public static void removeAllVolume(ArrayList<Ramen> arr, int volume) {
        ListIterator<Ramen> iter = arr.listIterator();
        while(iter.hasNext()) {
            Ramen r = iter.next();
            if(r.getVolume() == volume)
                iter.remove();
        }
    }

}
