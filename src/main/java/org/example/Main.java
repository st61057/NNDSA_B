package org.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        VillageTreap villageTreap = new VillageTreap(144);
        Loader loader = new Loader();
        Scanner sc = new Scanner(System.in);

        System.out.println("Zvolte operaci");
        System.out.println("1 - Vložení pomocí zvoleného jména, nahodného klíče a priority");
        System.out.println("2 - Vložení pomocí zvoleného jména, klíče a priority");
        System.out.println("3 - Odebrání prvku pomocí klíče");
        System.out.println("4 - Výpis stromu");
        System.out.println("5 - Export stromu do souboru");
        System.out.println("6 - Import stromu ze souboru");
        System.out.println("0 - Ukončit");
        boolean end = false;
        while (!end) {
            switch (sc.next()) {
                case "1": {
                    System.out.print("Zadejte jméno vesnice: ");
                    villageTreap.insertVillage(sc.next());
                    System.out.println("Vloženo");
                    break;
                }
                case "2": {
                    System.out.print("Zadejte jméno vesnice: ");
                    String name = sc.next();
                    System.out.print("Zadejte klíč: ");
                    Character key = sc.next().charAt(0);
                    System.out.print("Zadejte prioritu: ");
                    Integer priority = Integer.valueOf(sc.next());
                    villageTreap.insert(key, priority, name);
                    System.out.println("Vloženo");
                    break;
                }
                case "3": {
                    System.out.print("Zadejte odebíraný klíč: ");
                    String input = sc.next();
                    if (input.length() > 1) {
                        System.out.println("Neplatný klíč! musí být jeden znak");
                        break;
                    }
                    villageTreap.delete(input.charAt(0));
                    System.out.println("Odebráno");
                    break;
                }
                case "4": {
                    System.out.println("Výpis");
                    System.out.println(print(villageTreap));
                    break;
                }
                case "5": {
                    System.out.println("Export");
                    System.out.println("Chcete exportovat i statistiky? Y/N");
                    boolean isFullExport;
                    String input = sc.next();
                    if (input.equals("Y")) {
                        isFullExport = true;
                    } else if (input.equals("N")) {
                        isFullExport = false;
                    } else {
                        System.out.println("Neplatný znak");
                        break;
                    }
                    loader.exportData(villageTreap, isFullExport);
                    System.out.println("Exportováno");
                    break;
                }

                case "6": {
                    System.out.println("Import");
                    System.out.println("Zadejte cestu k souboru s příponou");
                    loader.importData(sc.next(), villageTreap);
                    break;
                }
                case "0": {
                    end = true;
                    break;
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
                sb.append(" - level " + level + "\n");
                level = node.getSecond();
            }
            AbstractTreap.TreapNode currentNode = node.getFirst();
            sb.append(currentNode.getKey() + ":" + currentNode.getPriority() + " ");
        }
        return sb.toString();
    }
}