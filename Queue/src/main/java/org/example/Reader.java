package org.example;

import java.util.Random;

/**
 * Klasa odpowiedzialna za tworzenie czytelnika
 */
public class Reader extends Thread{
    private Library library;
    private int id;

    /**
     * Konstruktor klasy Reader
     * @param library - obiekt klasy Library
     * @param id - id czytelnika
     */
    public Reader(Library library, int id) {
        this.library = library;
        this.id = id;
    }

    /**
     * Metoda run odpowiedzialna za czytanie
     */
    @Override
    public void run() {
        while (true) {
            if (library.requestRead()) {
                System.out.println("Reader " + id + " is reading");
                try {
                    Random random = new Random();
                    Thread.sleep((random.nextInt(3000) + 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                library.releaseReader();
                System.out.println("Reader " + id + " has finished reading");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    /**
     * Metoda toString odpowiedzialna za wyswietlanie czytelnika
     * @return
     */
    @Override
    public String toString() {
        return "reader" + id;
    }
}
