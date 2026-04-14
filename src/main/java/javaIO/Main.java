package javaIO;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ByteFileOperations byteFileOperations = new ByteFileOperations();
        byteFileOperations.readBytesFromFile();
    }
}
