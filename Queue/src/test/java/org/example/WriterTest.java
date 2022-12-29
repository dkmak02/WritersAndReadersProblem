package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {

    @Test
    void testToString() {
        Writer writer = new Writer(new Library(), 1);
        assertEquals("Writer1", writer.toString());
    }
}