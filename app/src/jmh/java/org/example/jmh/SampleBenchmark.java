package org.example.jmh;

import org.example.InvertedIndex;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.io.StringReader;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)

public class SampleBenchmark {

    @Param({"10", "50", "100", "200", "500", "1000"})
    private int size;

    private String text;

    @Setup
    public void setup() {
        String base = "The brown cat and the blue rat live in the brown house. ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(base);
        }
        text = sb.toString();
    }

    @Benchmark
    public void indexBuild(Blackhole bh) {
        InvertedIndex index = new InvertedIndex();
        int pos = 0;
        Scanner sc = new Scanner(new StringReader(text));
        while (sc.hasNext()) {
            String w = sc.next().replaceAll("[^a-zA-Z0-9-]", "").toLowerCase();
            if (!w.isEmpty() && !w.equals("the") && !w.equals("and") && !w.equals("in")) {
                index.addWord(w, pos);
            }
            pos++;
        }
        sc.close();
        bh.consume(index);
    }
}
