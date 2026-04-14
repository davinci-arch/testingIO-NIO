package javaIO;

import java.io.*;
import java.util.Arrays;

public class ByteFileOperations {

    private final String PATH_TO_FILE = "sample_bytes.bin";

    public byte[] readBytesFromFile() throws IOException {
        InputStream inputStream = new FileInputStream(PATH_TO_FILE);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] content;
        try (DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {
            content = dataInputStream.readAllBytes();
            System.out.println(Arrays.toString(content));
        }

        return content;
    }
    public void writeBytesToFile() throws IOException {
        var path = "newBytesFile.bin";
        OutputStream outputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedWriter = new BufferedOutputStream(outputStream);
        try (DataOutputStream dataOutputStream = new DataOutputStream(bufferedWriter)) {
            dataOutputStream.write(readBytesFromFile());
        }

    }
}
