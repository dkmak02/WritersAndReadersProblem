package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void testToString() {
        Reader reader = new Reader(new Library(), 1);
        assertEquals("reader1", reader.toString());
    }
}