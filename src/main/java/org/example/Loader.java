package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Loader {
    public void importData(String fileName, VillageTreap villageTreap) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parsedRecord = line.split(",");
//            villageTreap.insertVillage(parsedRecord[0], Integer.valueOf(parsedRecord[1]), parsedRecord[2]);
            villageTreap.insertVillage(parsedRecord[0], parsedRecord[2]);
        }
    }

    public void exportData(VillageTreap villageTreap, boolean full) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));

        for (Iterator<Tuple<AbstractTreap<String, Integer, String>.TreapNode, Integer>> it = villageTreap.levelOrderIterator(); it.hasNext(); ) {
            Tuple<AbstractTreap<String, Integer, String>.TreapNode, Integer> node = it.next();
            AbstractTreap.TreapNode currentNode = node.getFirst();
            writer.write(currentNode.getKey() + "," + currentNode.getPriority() + "," + currentNode.getValue().toString() + "\n");
        }
        if (full) {
            int height = villageTreap.height();
            Statistics statistics = new Statistics(Arrays.asList(height));
            writer.write("Max - " + statistics.max());
            writer.write("Min - " + statistics.min());
            writer.write("Mod - " + statistics.modus());
            writer.write("Mod - " + statistics.cumulative_average());
        }
        writer.flush();
        writer.close();
    }

}
