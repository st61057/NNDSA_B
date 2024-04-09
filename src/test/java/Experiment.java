import org.example.Generator;
import org.example.Statistics;
import org.example.VillageTreap;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Experiment {

    VillageTreap villageTreap = new VillageTreap(new Generator(144));

    @Test
    public void test() throws IOException {
        String fileName = "test.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        List<Integer> heights = new ArrayList<>();
        for (int j = 0; j < 10000; j++) {
            for (int i = 0; i < 1023; i++) {
                String name = "villageName" + i;
                writer.write(name + "\n");
                villageTreap.insertVillage(name, name);
            }
            int height = villageTreap.height();
            writer.write("Height - " + height + "\n");
            heights.add(height);
            villageTreap.cleanTree();
        }
        writer.write("\n");
        writer.write("Statistics\n");
        Statistics statistics = new Statistics(heights);
        writer.write("Max - " + statistics.max() + "\n");
        writer.write("Min - " + statistics.min() + "\n");
        writer.write("Mod [ ");
        List<Integer> modusList = statistics.modus();
        for (int i = 0; i < modusList.size(); i++) {
            writer.write(modusList.get(i) + ",");
        }
        writer.write("]\n");
        writer.write("Cumulative [ " + "\n");
        List<Double> cumulativeList = statistics.cumulative_average();
        for (int i = 0; i < cumulativeList.size(); i++) {
            writer.write(String.format("%.7g", cumulativeList.get(i)) + "\n");
        }
        writer.write("]");
        writer.flush();
        writer.close();

    }
}
