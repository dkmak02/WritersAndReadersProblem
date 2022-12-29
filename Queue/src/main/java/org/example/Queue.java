package org.example;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Klasa odpowiedzialna za tworzenie kolejki
 */
public class Queue {
    private static Library library = new Library();

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> queue = new ArrayList<>();
        /**
         * Dodawanie do kolejki 10 obiektow klasy Reader
         */
        Collections.addAll(queue, library.reader);
        /**
         * Dodanie do kolejki 3 watkow piszacych
         */
        Collections.addAll(queue, library.writer);
        /**
         * Mieszanie kolejki
         */
        for (int i = 0; i < queue.size(); i++) {
            int random = (int) (Math.random() * queue.size());
            Object temp = queue.get(i);
            queue.set(i, queue.get(random));
            queue.set(random, temp);
        }
        //Wypisanie kolejki
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i));
        }
        System.out.println("Ilosc czetelnikow w kolejsce: "+ library.reader.length);
        System.out.println("Ilosc pisarzy w kolejsce: "+library.writer.length);
        /**
         * Uruchamianie watkow w kolejnosci zdefiniowanej w kolejce
         */
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) instanceof Reader) {
                ((Reader) queue.get(i)).start();
            } else {

                ((Writer) queue.get(i)).start();
                ((Writer) queue.get(i)).join();

            }
        }



    }
}
