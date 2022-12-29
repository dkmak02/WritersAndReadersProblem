package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
class LibraryTest
{
    @org.junit.jupiter.api.Test
    void requestRead() {
        Library l1 = new Library();
        Reader r1 = new Reader(l1,1);
        r1.start();
        assertTrue(l1.requestRead());
    }

    @org.junit.jupiter.api.Test
    void requestWrite() {
        Library l1 = new Library();
        Writer w1 = new Writer(l1,1);
        w1.start();
        assertEquals(true,l1.requestWrite());
    }

    @org.junit.jupiter.api.Test
    void releaseReader() {
        Library l1 = new Library();
        Reader r1 = new Reader(l1,1);
        Reader r2 = new Reader(l1,2);
        Reader r3 = new Reader(l1,3);
        r1.start();
        assertEquals(5,l1.semaphore.availablePermits());
        r2.start();
        r3.start();
        assertEquals(4,l1.semaphore.availablePermits());
    }

    @org.junit.jupiter.api.Test
    void releaseWriter() {
        Library l1 = new Library();
        Writer w1 = new Writer(l1,1);
        w1.start();
        assertEquals(5,l1.semaphore.availablePermits());
    }
}
