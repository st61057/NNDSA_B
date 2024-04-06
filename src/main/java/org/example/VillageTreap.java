package org.example;

public class VillageTreap extends AbstractTreap<Character, Integer, String> {

    Generator generator;

    public VillageTreap(Integer seed) {
        this.generator = new Generator(seed);
    }

    public void insertVillage(String villageName) {
        Character key = generator.keyGenerator();
        Integer priority = generator.priorityGenerator();
        insert(key, priority, villageName);
    }
}
