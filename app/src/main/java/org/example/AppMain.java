package org.example;

import java.io.*;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        InvertedIndex index = new InvertedIndex();

        try {
            List<String> words = ProcessText.readWords(inputFile);

            for(int i = 0; i < words.size(); i++){
                index.addWord(words.get(i), i);
            }

            try(PrintWriter writer = new PrintWriter(new FileWriter(outputFile))){
                writer.println(index.toString());
            }

            System.out.println("Inverted index: " + index);
        } 

        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
