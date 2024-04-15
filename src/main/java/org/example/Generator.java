package org.example;

import java.util.Random;

public class Generator implements IGenerator<Integer> {

    Random random;

    public Generator() {
        this.random = new Random((int) (10000 * Math.random()));
    }

    @Override
    public Integer priorityGenerator() {
        return random.nextInt();
    }

}
