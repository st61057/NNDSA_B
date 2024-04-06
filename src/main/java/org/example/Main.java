package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        VillageTreap villageTreap = new VillageTreap(154);
        villageTreap.insertVillage("TEST1");
        villageTreap.insertVillage("TEST2");
        villageTreap.insertVillage("TEST3");
        villageTreap.insertVillage("TEST4");
        villageTreap.insertVillage("TEST5");
        villageTreap.insertVillage("TEST6");
    }
}