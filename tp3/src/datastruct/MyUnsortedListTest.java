package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUnsortedListTest {

    @Test
    public void testIsEmpty(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4,5);
        assertEquals(myList.isEmpty(), false);
        assertNotEquals(myList.isEmpty(), true);

        myList = MyUnsortedList.of();
        assertEquals(myList.isEmpty(), true);
        assertNotEquals(myList.isEmpty(), false);
    }

    @Test
    public void testSize(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4);
        assertEquals(myList.size(), 4);
        assertNotEquals(myList.size(), 18);

        myList = MyUnsortedList.of(1,2,3,4,566,6);
        assertEquals(myList.size(), 6);
        assertNotEquals(myList.size(), 7);
    }

    @Test
    public void testPrepend(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4);
        UnsortedList<Integer> mySecondList = MyUnsortedList.of(5,1,2,3,4);
        myList.prepend(5);
        assertEquals(myList.size(), 5);
        assertEquals(myList.equals(mySecondList), true);

        myList.prepend(6);
        myList.prepend(7);
        myList.prepend(8);
        myList.prepend(9);
        assertEquals(myList.size(), 9);
        assertEquals(myList.equals(mySecondList), false);
        mySecondList = MyUnsortedList.of(9,8,7,6,5,1,2,3,4);
        assertEquals(myList.equals(mySecondList), true);
    }


    @Test
    public void testAppend(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4);
        UnsortedList<Integer> mySecondList = MyUnsortedList.of(1,2,3,4,5);
        myList.append(5);
        assertEquals(myList.size(), 5);
        assertEquals(myList.equals(mySecondList), true);

        myList.append(6);
        myList.append(7);
        assertEquals(myList.size(), 7);
        myList.append(8);
        myList.append(9);
        assertEquals(myList.size(), 9);
        assertEquals(myList.equals(mySecondList), false);
        mySecondList = MyUnsortedList.of(1,2,3,4,5,6,7,8,9);
        assertEquals(myList.equals(mySecondList), true);
    }

    @Test
    public void testInsert(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4);
        UnsortedList<Integer> mySecondList = MyUnsortedList.of(1,2,5,3,4);

        myList.insert(5,2);
        assertEquals(myList.size(), 5);
        assertEquals(myList.equals(mySecondList), true);

        myList.insert(6,4);
        myList.insert(7,6);
        myList.insert(8,0);
        myList.insert(9,5);
        assertEquals(myList.size(), 9);
        assertEquals(myList.equals(mySecondList), false);
        mySecondList = MyUnsortedList.of(8,1,2,5,3,9,6,4,7);
        assertEquals(myList.equals(mySecondList), true);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testInsertNegValue() throws Exception{
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4);

        myList.insert(8,-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testInsertPosValue() throws Exception{
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4);

        myList.insert(8,18);
    }

    @Test
    public void testPop(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4,5,6,7,8);
        UnsortedList<Integer> mySecondList = MyUnsortedList.of(2,3,4,5,6,7,8);

        int elem = myList.pop();
        assertEquals(elem, 1);

        assertEquals(myList.size(), 7);
        assertEquals(myList.equals(mySecondList), true);

        myList.pop();
        elem = myList.pop();
        assertEquals(elem, 3);

        myList.pop();
        elem = myList.pop();
        assertEquals(elem, 5);

        assertEquals(myList.size(), 3);
        assertEquals(myList.equals(mySecondList), false);
        mySecondList = MyUnsortedList.of(6,7,8);
        assertEquals(myList.equals(mySecondList), true);

        final UnsortedList<Integer> myEmptyList = MyUnsortedList.of();
        assertThrows(EmptyListException.class, ()->{
            myEmptyList.pop();
        });

    }

    @Test
    public void testPopLast(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4,5,6,7,8);
        UnsortedList<Integer> mySecondList = MyUnsortedList.of(1,2,3,4,5,6,7);

        int elem = myList.popLast();
        assertEquals(elem, 8);

        assertEquals(myList.size(), 7);
        assertEquals(myList.equals(mySecondList), true);

        myList.popLast();
        elem = myList.popLast();
        assertEquals(elem, 6);

        myList.popLast();
        elem = myList.popLast();
        assertEquals(elem, 4);

        assertEquals(myList.size(), 3);
        assertEquals(myList.equals(mySecondList), false);
        mySecondList = MyUnsortedList.of(1,2,3);
        assertEquals(myList.equals(mySecondList), true);

        UnsortedList<Integer> myEmptyList = MyUnsortedList.of();
        assertThrows(EmptyListException.class, ()->{
            myEmptyList.popLast();
        });
    
    }

    @Test
    public void testRemove(){
        UnsortedList<Integer> myList = MyUnsortedList.of(1,2,3,4,5,6,7,8);
        UnsortedList<Integer> mySecondList = MyUnsortedList.of(1,2,3,5,6,7,8);

        int elem = myList.remove(3);
        assertEquals(elem, 4);

        assertEquals(myList.size(), 7);
        assertEquals(myList.equals(mySecondList), true);

        myList.remove(4);
        elem = myList.remove(1);
        assertEquals(elem, 2);

        myList.remove(3);
        elem = myList.remove(2);
        assertEquals(elem, 5);

        myList.remove(0);
        
        assertEquals(myList.size(), 2);
        assertEquals(myList.equals(mySecondList), false);
        mySecondList = MyUnsortedList.of(3,8);
        assertEquals(myList.equals(mySecondList), true);

        UnsortedList<Integer> myEmptyList = MyUnsortedList.of(1,2,3);
        assertThrows(IndexOutOfBoundsException.class, ()->{
            myEmptyList.remove(-10);
        });

        assertThrows(IndexOutOfBoundsException.class, ()->{
            myEmptyList.remove(80);
        });
    }
}