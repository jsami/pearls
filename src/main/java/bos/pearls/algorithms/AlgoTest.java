package bos.pearls.algorithms;

import bos.pearls.IAlgorithm;

public class AlgoTest implements IAlgorithm {
    public void run() {
        System.out.println("Hello All!!! It Works");
        try {
            Thread.sleep(5000);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
