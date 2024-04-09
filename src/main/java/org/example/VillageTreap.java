package org.example;

import java.util.Iterator;

public class VillageTreap extends AbstractTreap<String, Integer, String> {

    AbstractTreap<String, Integer, String> treap;

    public VillageTreap(IGenerator<Integer> generator) {
        this.treap = new AbstractTreap<>(generator);
    }

    public void insertVillage(String key, String villageName) {
        if (doesKeyExist(key)) {
            throw new RuntimeException("Tento klíč již existuje");
        }

        treap.insert(key, villageName);
    }

    public boolean doesKeyExist(String key) {
        return treap.search(key) != null;
    }

    public String deleteVillage(String key) {
        if (doesKeyExist(key)) {
            return treap.delete(key);
        }
        throw new RuntimeException("klíč neexistuje");
    }

    @Override
    public Iterator<Tuple<AbstractTreap<String, Integer, String>.TreapNode, Integer>> levelOrderIterator() {
        return super.levelOrderIterator();
    }
}
