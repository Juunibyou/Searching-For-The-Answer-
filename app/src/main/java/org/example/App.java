package org.example;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        InvertedIndex index = new InvertedIndex();

        try (Scanner scanner = new Scanner(new File(inputFile))){

            int position = 0;

            while(scanner.hasNext()){
                String word = scanner.next();
                String cleanWord = "";

                for(int i = 0; i < word.length(); i++){

                    char c = word.charAt(i);
                    if (Character.isLetterOrDigit(c) || c == '-') {
                        cleanWord += Character.toLowerCase(c);
                    }
                }

                if (!cleanWord.isEmpty()) {
            
                    if (!ProcessText.isStopWord(cleanWord)) {
                        index.addWord(cleanWord, position);
                    }
                    position++;
                }
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

