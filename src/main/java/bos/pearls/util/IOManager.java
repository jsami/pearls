package bos.pearls.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class IOManager {
    private IOManager() {}

    public static BufferedReader getInput(String fileName) {
        try {
            return new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static BufferedWriter getOutput(String fileName) {
        try {
            return new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int readInt(BufferedReader reader) {
        try {
            String line = reader.readLine();
            return line != null ? Integer.parseInt(line) : -1;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void writeInt(BufferedWriter output, int i) {
        try {
            output.write(i);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void dispose(Closeable... closeables) {
        for(Closeable closeable: closeables) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
