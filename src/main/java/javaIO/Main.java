package javaIO;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var obj = new BasicFileReader();

        obj.readTextFile();
        obj.readTextFile_FileReader();
        obj.readTextFile_FileInput();
    }
}
