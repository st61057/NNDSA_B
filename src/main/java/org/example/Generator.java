package org.example;

import java.util.Random;

public class Generator {

    Random random;

    public Generator(int seed) {
        this.random = new Random(seed);
    }

    public int priorityGenerator() {
        return random.nextInt();
    }
}
