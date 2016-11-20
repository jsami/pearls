package bos.pearls.algorithms;

import bos.pearls.IAlgorithm;

public class AlgoTest2 implements IAlgorithm {

    public void setup() {
        System.out.println("Yet another test!!!");
    }

    public void run() {
        try {
            Thread.sleep(520);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
