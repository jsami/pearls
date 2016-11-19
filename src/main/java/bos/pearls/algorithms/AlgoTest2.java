package bos.pearls.algorithms;

import bos.pearls.IAlgorithm;

public class AlgoTest2 implements IAlgorithm {
    public void run() {
        System.out.println("Yet another test!!!");
        try {
            Thread.sleep(520);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
