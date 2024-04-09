import org.example.Generator;
import org.example.VillageTreap;
import org.junit.Test;

import static org.example.Main.print;

public class OperationsTests {
    VillageTreap villageTreap = new VillageTreap(new Generator(144));

    @Test
    public void insertTest() {
        villageTreap.insertVillage("G", "villageName1");
        villageTreap.insertVillage("B", "villageName2");
        villageTreap.insertVillage("H", "villageName3");
        villageTreap.insertVillage("A", "villageName4");
        villageTreap.insertVillage("E", "villageName5");
        villageTreap.insertVillage("K", "villageName6");
        villageTreap.insertVillage("I", "villageName7");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insertVillage("C", "villageName8");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insertVillage("D", "villageName9");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insertVillage("F", "villageName10");
        System.out.println(print(villageTreap));
    }

    @Test
    public void insertSpecifiedTest() {
        villageTreap.insertSpecifiedVillage("G", 4, "villageName1");
        villageTreap.insertSpecifiedVillage("B", 7, "villageName2");
        villageTreap.insertSpecifiedVillage("H", 5, "villageName3");
        villageTreap.insertSpecifiedVillage("A", 10, "villageName4");
        villageTreap.insertSpecifiedVillage("E", 23, "villageName5");
        villageTreap.insertSpecifiedVillage("K", 65, "villageName6");
        villageTreap.insertSpecifiedVillage("I", 73, "villageName7");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insertSpecifiedVillage("C", 25, "villageName8");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insertSpecifiedVillage("D", 9, "villageName9");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insertSpecifiedVillage("F", 2, "villageName10");
        System.out.println(print(villageTreap));
    }

    @Test
    public void deleteTest() {
        villageTreap.insertVillage("G", "villageName1");
        villageTreap.insertVillage("E", "villageName2");
        villageTreap.insertVillage("X", "villageName3");
        villageTreap.insertVillage("B", "villageName4");
        villageTreap.insertVillage("F", "villageName5");
        villageTreap.insertVillage("M", "villageName6");
        villageTreap.insertVillage("Z", "villageName7");
        villageTreap.insertVillage("A", "villageName7");
        villageTreap.insertVillage("C", "villageName7");
        villageTreap.insertVillage("K", "villageName7");
        villageTreap.insertVillage("P", "villageName7");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.deleteVillage("G");
        System.out.println(print(villageTreap));
    }
}
