package bos.pearls.algorithms.column1;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class BitVectorTest {

    private static final int SIZE = 10;
    private BitVector bitVector;

    @Before
    public void setup() {
        bitVector = BitVector.ofSize(SIZE);
    }

    @Test
    public void clear() {
        bitVector.clear();
        boolean isCleared = true;
        for(int i = 0; i < bitVector.getSize(); i++) {
            isCleared = isCleared && !bitVector.isSet(i);
        }

        assertTrue(isCleared);
    }

    @Test
    public void getSize() {
        assertEquals(SIZE, bitVector.getSize());
    }

    @Test
    public void set() {
        bitVector.clear();

        bitVector.set(5);
        bitVector.set(2);
        bitVector.set(7);

        assertTrue(bitVector.isSet(5));
        assertTrue(bitVector.isSet(2));
        assertTrue(bitVector.isSet(7));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundOnSizeSet() {
        bitVector.set(SIZE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundOverSizeSet() {
        bitVector.set(SIZE + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeIndexSet() {
        bitVector.set(-1);
    }

    @Test
    public void unset() {
        bitVector.clear();
        bitVector.set(5);
        bitVector.set(2);
        bitVector.set(7);

        bitVector.unset(5);
        bitVector.unset(2);

        assertFalse(bitVector.isSet(5));
        assertFalse(bitVector.isSet(2));
        assertTrue(bitVector.isSet(7));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundOnSizeUnSet() {
        bitVector.unset(SIZE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundOverSizeUnSet() {
        bitVector.unset(SIZE + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeIndexUnSet() {
        bitVector.unset(-1);
    }

    @Test
    public void isSet() {
        bitVector.clear();

        bitVector.set(5);

        assertTrue(bitVector.isSet(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundOnSizeIsSet() {
        bitVector.isSet(SIZE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundOverSizeIsSet() {
        bitVector.isSet(SIZE + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeIndexIsSet() {
        bitVector.isSet(-1);
    }

}