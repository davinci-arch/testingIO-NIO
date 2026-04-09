package javaIO;

import java.io.*;
import java.util.Scanner;

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

    public void writeTextToFile() throws IOException {
        OutputStream out = new FileOutputStream(relativePathToFile, true);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        String text = "";
        Scanner scanner = new Scanner(System.in);

        while (!(text = scanner.nextLine()).equals("exit")) {
            writer.write(text);
            writer.append(System.lineSeparator());
            writer.flush();
        }
        scanner.close();
        out.close();
    }

    public void writeTextToFile_FileOutput() throws IOException {
        FileOutputStream out = new FileOutputStream(relativePathToFile, true);

        String text = "";
        Scanner scanner = new Scanner(System.in);
        while(!(text = scanner.nextLine()).equals("exit")) {
            for(char c : text.toCharArray()) {
                int ch = c;
                out.write(ch);
            }
            out.write('\n');
            out.flush();
        }
        scanner.close();
        out.close();
    }

    public void writeTextToFile_FileWriter() throws IOException {
        FileWriter fw = new FileWriter(relativePathToFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        Scanner scanner = new Scanner(System.in);
        String line;
        while(!(line = scanner.nextLine()).equals("exit")) {
            bw.write(line);
            bw.write(System.lineSeparator());
        }

        scanner.close();
        bw.close();
    }
}
