package javaIO;

import java.io.*;

public class BasicFileReader {

    private String relativePathToFile = "file.txt";


    //The most usable implementation of reading file
    public void readTextFile() throws IOException {
        InputStream in = new FileInputStream(relativePathToFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        StringBuilder resultedString = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (!resultedString.isEmpty()) {
                resultedString.append("\n");
            }
            resultedString.append(line);

        }
        reader.close();
        System.out.println(resultedString);
    }

    public void readTextFile_FileInput() throws IOException {
        FileInputStream fr = new FileInputStream(relativePathToFile);
        StringBuilder fileContent = new StringBuilder();
        int ch;
        while((ch = fr.read()) != -1) {
            char character = (char) ch;
            fileContent.append(character);
        }
        fr.close();
        System.out.println(fileContent);
    }

    public void readTextFile_FileReader() throws IOException {

        StringBuilder fileContent = new StringBuilder();
        try (FileReader fr = new FileReader(relativePathToFile)) {
            char character;
            int ch;
            while((ch = fr.read()) != -1) {
                character = (char) ch;
                fileContent.append(character);
            }
        }
        System.out.println(fileContent);
    }

}
