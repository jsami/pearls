package bos.pearls.algorithms.column1;

/**
 * Implementation of a bit vector using bitwise operations (and, or, shift)
 */
public final class BitVector {

    private int numberOfBytes;
    private byte[] bits;
    private byte MASK = (byte)0x80;

    private BitVector(int size) {
        numberOfBytes = byteIndex(size - 1) + 1;
        bits = new byte[numberOfBytes];
    }

    public static BitVector ofSize(int size) {
        return new BitVector(size);
    }

    private int byteIndex(int bitIndex) {
        return bitIndex >> 3;
    }

    public void clear() {
        for(int i = 0; i < numberOfBytes; i++) {
            bits[i] &= 0;
        }
    }

    public void set(int index) {
        bits[byteIndex(index)] |= (MASK >> index);
    }

    public void unset(int index) {
        bits[byteIndex(index)] &= ~(MASK >> index);
    }

    public boolean isSet(int index) {
        return (bits[byteIndex(index)] & (MASK >> index)) != 0;
    }

}
