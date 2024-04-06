package org.example;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VillageTreap villageTreap = new VillageTreap(144);
        Scanner sc = new Scanner(System.in);

        boolean end = false;
        while (!end) {
            System.out.println("Zvol operaci");
            switch (sc.next()) {
                case "1": {
                    System.out.print("Zadej jméno vesnice: ");
                    villageTreap.insertVillage(sc.next());
                    System.out.println("Vloženo");
                    break;
                }
                case "2": {
                    System.out.print("Zadej odebíraný klíč: ");
                    String input = sc.next();
                    if (input.length() > 1) {
                        System.out.println("Neplatný klíč! musí být jeden znak");
                        break;
                    }
                    villageTreap.delete(input.charAt(0));
                    System.out.println("Odebráno");
                    break;
                }
                case "3": {
                    System.out.println("Výpis");
                    System.out.println(print(villageTreap));
                }
            }
        }
    }

    public static String print(VillageTreap villageTreap) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (Iterator<Tuple<AbstractTreap<Character, Integer, String>.TreapNode, Integer>> it = villageTreap.levelOrderIterator(); it.hasNext(); ) {
            Tuple<AbstractTreap<Character, Integer, String>.TreapNode, Integer> node = it.next();
            if (level != node.getSecond()) {
                sb.append("\n");
                level = node.getSecond();
            }
            AbstractTreap.TreapNode currentNode = node.getFirst();
            sb.append(currentNode.getKey() + ":" + currentNode.getPriority()/* + "- level - " + node.getSecond() +" "*/);
        }
        return sb.toString();
    }
}