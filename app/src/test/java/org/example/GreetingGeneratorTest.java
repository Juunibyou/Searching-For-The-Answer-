package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class GreetingGeneratorTest {
    @Test
    void AddAndRetrieve(){
        InvertedIndex index = new InvertedIndex();

        index.addWord("cat", 0);
        index.addWord("dog", 1);
        index.addWord("cat", 2);

        assertEquals(Arrays.asList(0, 2), index.getIndex().get("cat"));
        assertEquals(Arrays.asList(1), index.getIndex().get("dog"));

        assertNull(index.getIndex().get("bird"));
    }

    void ignoresStopWords() {
        assertTrue(ProcessText.isStopWord("the"));
        assertFalse(ProcessText.isStopWord("house"));
    }
}
