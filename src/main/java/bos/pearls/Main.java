package bos.pearls;

import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

import java.util.List;

import static bos.pearls.Algorithms.*;

public class Main {
    public static void main(String[] args) {
        List<IAlgorithm> algos = getAlgorithms();
        for(IAlgorithm algo : algos) {
            run(algo);
        }
    }

    public static void run(IAlgorithm algo) {
        StopWatch timer = new LoggingStopWatch();
        algo.run();
        timer.stop(algo.getClass().getName());
    }
}
