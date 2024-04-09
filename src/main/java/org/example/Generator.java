package org.example;

import java.util.Random;

public class Generator implements IGenerator<Integer> {

    Random random;

    public Generator(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Integer priorityGenerator() {
        return random.nextInt();
    }

}
