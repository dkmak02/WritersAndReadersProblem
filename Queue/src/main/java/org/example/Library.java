package org.example;


import java.util.concurrent.Semaphore;

/**
 * Klasa odpowiedzialna za tworzenie biblioteki
 */
public class Library {
    public  Semaphore semaphore = new Semaphore(5);
    protected  Reader[] reader = new Reader[10];
    protected Writer[] writer = new Writer[3];

    /**
     * Konstruktor klasy Library odpowiedzialny za tworzenie obiektow klasy Reader i Writer
     */
    public Library() {
        for (int i = 0; i < 10; i++) {
            reader[i] = new Reader(this, i);
        }
        for (int i = 0; i < 3; i++) {
            writer[i] = new Writer(this, i);
        }
    }

    /**
     * Metoda odpowiedzialna za zapytanie czy mozna czytac
     * @return - zwraca true jesli mozna czytac
     */
    public boolean requestRead() {
            try {
                semaphore.acquire();
                return true;
            } catch (InterruptedException e) {
                return false;
            }
    }

    /**
     * Metoda odpowiedzialna za zapytanie czy mozna pisac
     * @return - zwraca true jesli mozna pisac
     */
    public boolean requestWrite() {
            try {
                semaphore.acquire(5);

                return true;
            } catch (InterruptedException e) {
                return false;
            }
    }
    /**
     * Metoda odpowiedzialna za zwolnienie czytelnika
     */
    public void releaseReader() {
        semaphore.release();

    }
    /**
     * Metoda odpowiedzialna za zwolnienie pisarza
     */
    public void releaseWriter() {
        semaphore.release(5);

    }

}
