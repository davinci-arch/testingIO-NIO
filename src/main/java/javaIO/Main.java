package javaIO;

import javaNIO.TextFileOperations;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       var obj = new TextFileOperations();
       obj.readDataFromFile();
    }
}
