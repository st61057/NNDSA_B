import org.example.VillageTreap;
import org.junit.Test;

import static org.example.Main.print;

public class OperationsTests {
    VillageTreap villageTreap = new VillageTreap(144);

    @Test
    public void insertTest() {
        villageTreap.insert('G', 4, "villageName1");
        villageTreap.insert('B', 7, "villageName2");
        villageTreap.insert('H', 5, "villageName3");
        villageTreap.insert('A', 10, "villageName4");
        villageTreap.insert('E', 23, "villageName5");
        villageTreap.insert('K', 65, "villageName6");
        villageTreap.insert('I', 73, "villageName7");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insert('C', 25, "villageName8");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insert('D', 9, "villageName9");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.insert('F', 2, "villageName10");
        System.out.println(print(villageTreap));
    }

    @Test
    public void deleteTest() {
        villageTreap.insert('G', 40, "villageName1");
        villageTreap.insert('E', 69, "villageName2");
        villageTreap.insert('X', 50, "villageName3");
        villageTreap.insert('B', 77, "villageName4");
        villageTreap.insert('F', 84, "villageName5");
        villageTreap.insert('M', 67, "villageName6");
        villageTreap.insert('Z', 90, "villageName7");
        villageTreap.insert('A', 99, "villageName7");
        villageTreap.insert('C', 79, "villageName7");
        villageTreap.insert('K', 70, "villageName7");
        villageTreap.insert('K', 72, "villageName7");
        System.out.println(print(villageTreap));
        System.out.println("-----");
        villageTreap.delete('C');
        System.out.println(print(villageTreap));
    }
}
