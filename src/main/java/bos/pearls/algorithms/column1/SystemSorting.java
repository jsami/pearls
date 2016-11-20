package bos.pearls.algorithms.column1;

import java.util.Arrays;

import bos.pearls.IAlgorithm;
import bos.pearls.util.Data;

public class SystemSorting implements IAlgorithm {
    private int[] input;

    public void setup() {
        input = Arrays.copyOf(Data.INTEGERS, Data.INTEGERS.length);
        System.out.println("System Sorting ... Array Length: " + input.length);
    }

    public void run() {
        Arrays.sort(input);
    }
}
