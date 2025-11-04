package org.example;

import java.util.*;

public class InvertedIndex {
    public Map<String, List<Integer>> index;

    public InvertedIndex(){
        index = new TreeMap<>();
    }

    public void addWord(String word, int position){
        if(!index.containsKey(word)){
            index.put(word, new ArrayList<>());
        }
        index.get(word).add(position);
    }

    public Map<String, List<Integer>> getIndex(){
        return index;
    }

    public String toString(){
        String result = "{\n";

        for (String word : index.keySet()) {
            result += "  \"" + word + "\": " + index.get(word) + "\n";
        }

        result += "}";
        return result;
    }

}
