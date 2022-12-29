package org.example;
import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Klasa odpowiedzialna za tworzenie pisarza
 */
public class Writer extends Thread{
    private Library library;
    private int id;

    /**
     * Konstruktor klasy Writer
     * @param library - obiekt klasy Library
     * @param id - id pisarza
     */
    public Writer(Library library, int id) {
        this.library = library;
        this.id = id;
    }

    /**
     * Metoda run odpowiedzialna za pisanie
     */
    @Override
    public void run() {
        while (true) {
            if (library.requestWrite()) {
                System.out.println("Writer " + id + " is writing");
                try {
                    Random random = new Random();
                    Thread.sleep((random.nextInt(3000) + 1000));
                } catch (InterruptedException e) {
                    Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
                }
                library.releaseWriter();
                System.out.println("Writer " + id + " has finished writing");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Writer" + id;
    }
}
