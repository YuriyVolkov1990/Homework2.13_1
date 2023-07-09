package com.example.homework2_13_1;

import com.example.homework2_13_1.Exception.InvalidIndexException;
import com.example.homework2_13_1.Exception.NullItemException;
import com.example.homework2_13_1.Exception.StorageIsFullException;
import com.example.homework2_13_1.Impl.StringListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {
    @Test
    void add() {
        StringListImpl m = new StringListImpl(5);
        m.add("aaaaa");
        assertTrue(m.contains("aaaaa"));
    }
    @Test
    void addByIndex() {
        StringListImpl m = new StringListImpl(5);
        m.add(0, "ddddd");
        m.add(1, "fffff");
        assertTrue(m.contains("ddddd"));
        assertTrue(m.contains("fffff"));
    }
    @Test
    void set() {
        StringListImpl m = new StringListImpl(5);
        m.add("aaaa");
        m.set(0, "bbbb");
        assertNotEquals("aaaa","bbbb");
        assertTrue(m.contains("bbbb"));
    }
    @Test
    void removeByItem() {
        StringListImpl m = new StringListImpl(5);
        m.add("aaaa");
        assertTrue(m.contains("aaaa"));
        m.remove("aaaa");
        assertFalse(m.contains("aaaa"));
    }
    @Test
    void removeByIndex() {
        StringListImpl m = new StringListImpl(5);
        m.add(0,"aaaa");
        assertTrue(m.contains("aaaa"));
        m.remove(0);
        assertFalse(m.contains("aaaa"));
    }
    @Test
    void testNullItemException() {
        StringListImpl m = new StringListImpl(5);
        assertThrows(NullItemException.class, ()->m.add(null));
    }
    @Test
    void testStorageIsFullException() {
        StringListImpl m = new StringListImpl(5);
        m.add("1");
        m.add("2");
        m.add("3");
        m.add("4");
        m.add("5");
        assertThrows(StorageIsFullException.class, ()->m.add("6"));
    }
    @Test
    void testInvalidIndexException() {
        StringListImpl m = new StringListImpl(5);
        assertThrows(InvalidIndexException.class, ()->m.add(-1,"aaaa"));
    }
}
