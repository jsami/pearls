package bos.pearls.algorithms.column1;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import bos.pearls.IAlgorithm;
import bos.pearls.util.IOManager;

public class BitMapSorting implements IAlgorithm {

    BitVector bitVector;

    BufferedReader input;
    BufferedWriter output;

    private final int VECTOR_SIZE = 10000000;
    private final String INPUT_FILE = "input.txt";
    private final String OUTPUT_FILE = "output.txt";

    public void setup() {
        bitVector = BitVector.ofSize(VECTOR_SIZE);
        bitVector.clear();
        input = IOManager.getInput(INPUT_FILE);
        output = IOManager.getOutput(OUTPUT_FILE);
    }

    public void run() {
        int entry;
        while((entry = IOManager.readInt(input)) > 0) {
            bitVector.set(entry);
        }

        for(int i = 0; i < bitVector.getSize(); i++) {
            if(bitVector.isSet(i))
                IOManager.writeInt(output, i);
        }
    }

    public void cleanup() {
        IOManager.dispose(input, output);
    }

}
