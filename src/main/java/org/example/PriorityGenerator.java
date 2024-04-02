package org.example;

import java.util.Random;

public class PriorityGenerator {

    Random random;

    public PriorityGenerator(int seed) {
        this.random = new Random(seed);
    }

    public int priorityGenerator() {
        return random.nextInt();
    }
}
