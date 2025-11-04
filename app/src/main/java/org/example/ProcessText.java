package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ProcessText {
    private static final Set<String> StopWords = new HashSet<>(Arrays.asList(
        "a", "an", "and", "the", "to", "for", "they", "you", "your",
        "in", "of", "on", "is", "it", "that", "this"
    ));

    public static boolean isStopWord(String word) {
        return StopWords.contains(word);
    }

    public static List<String> readWords(String filename) throws IOException {
        List<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNext()){
                String word = scanner.next();
                String cleanWord = "";

                for (int i = 0; i < word.length(); i++){
                    char c = word.charAt(i);

                    if(Character.isLetterOrDigit(c) || c == '-'){
                        cleanWord += Character.toLowerCase(c);
                    }
                }

                if(!cleanWord.isEmpty() && !StopWords.contains(cleanWord)){
                    words.add(cleanWord);
                }
            }
        }
    
        return words;
    }
}
