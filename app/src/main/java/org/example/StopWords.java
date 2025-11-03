package org.example;
import java.util.*;

public class StopWords {
    private static final Set<String> StopWords = new HashSet<>(Arrays.asList(
        "a", "an", "and", "the", "to", "for", "they", "you", "your",
        "in", "of", "on", "is", "it", "that", "this"
    ));

    public static boolean isStopWord(String word){
        return StopWords.contains(word);
    }
}
