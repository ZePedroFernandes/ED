package Colecoes3;

import lists.LinkedList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    static LinkedList<Integer> list = new LinkedList<>();

    public static void setUp(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(-1);
    }

    @Test
    public void test_contains_1(){
        setUp();
        assertTrue(list.contains(1));
    }

    @Test
    public void test_contains_2(){
        assertTrue(list.contains(2));
    }

    @Test
    public void test_contains_3(){
        assertTrue(list.contains(3));
    }

    @Test
    public void test_contains_5(){
        assertTrue(list.contains(-1));
    }

    @Test
    public void test_contains_6(){
        assertFalse(list.contains(4));
    }

    @Test
    public void test_contains_7(){
        assertFalse(list.contains(-2));
    }

    @Test
    public void test_contains_8(){
        assertFalse(list.contains(1000));
    }
}
