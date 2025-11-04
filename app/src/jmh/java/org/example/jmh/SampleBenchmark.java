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

    private String text;

    @Setup
    public void setup() {
        text = "The brown cat and the blue rat live in the brown house.";
    }

    @Benchmark
    public void smallIndexBuild(Blackhole bh) {
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
        bh.consume(index);
        sc.close();
    }
}
