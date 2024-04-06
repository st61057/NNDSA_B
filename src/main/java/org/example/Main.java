package org.example;

import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        VillageTreap villageTreap = new VillageTreap(144);
        villageTreap.insertVillage("TEST1");
        System.out.println(print(villageTreap));

        System.out.println("------------");

        villageTreap.delete('e');
        System.out.println(print(villageTreap));
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