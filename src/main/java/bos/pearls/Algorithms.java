package bos.pearls;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static bos.pearls.util.Utils.checkNotNull;

public class Algorithms {
    private Algorithms() {}

    public static List<IAlgorithm> get() {
        String[] classNames = getAlgoClassNames().split(",");
        List<IAlgorithm> algorithms = new ArrayList<IAlgorithm>();
        for (String name : classNames) {
            String fullName = algoFullClassName(name.trim());
            algorithms.add(instantiate(fullName));
        }

        return algorithms;
    }

    private static String getAlgoClassNames() {
        Properties prop = new Properties();
        InputStream input;

        try {
            input = Algorithms.class.getResourceAsStream("config.properties");
            prop.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        String classNames = prop.getProperty("algorithms");
        return checkNotNull(classNames);
    }

    private static IAlgorithm instantiate(String className) {
        IAlgorithm algo;
        try {
            Class<?> algoClass = Class.forName(className);
            Constructor<?> ctor = algoClass.getConstructor();
            algo = (IAlgorithm) ctor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return algo;
    }

    private static String algoFullClassName(String name) {
        final String algoPackage = "bos.pearls.algorithms";
        return algoPackage + "." + name;
    }
}
