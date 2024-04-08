package org.example;

import javax.swing.tree.TreeNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public abstract class AbstractTreap<K extends Comparable<K>, P extends Comparable<P>, V> {

    protected class TreapNode {

        K key;

        P priority;

        V value;

        TreapNode left;
        TreapNode right;

        public TreapNode() {
            this.key = null;
            this.priority = null;
            this.value = null;
            this.left = this;
            this.right = this;
        }

        public TreapNode(K key, P priority, V value, TreapNode left, TreapNode right) {
            this.key = key;
            this.priority = priority;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreapNode(K key, P priority, V value) {
            this.key = key;
            this.priority = priority;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public V getValue() {
            return value;
        }

        public P getPriority() {
            return priority;
        }

        public void setPriority(P priority) {
            this.priority = priority;
        }

        public K getKey() {
            return key;
        }

        public TreapNode getLeft() {
            return left;
        }

        public TreapNode getRight() {
            return right;
        }
    }

    TreapNode root;

    private boolean isEmpty() {
        return root == null;
    }

    private TreapNode leftRotate(TreapNode node) {
        TreapNode rightChildNode = node.right;
        TreapNode rightsChildChildNode = rightChildNode.left;

        rightChildNode.left = node;
        node.right = rightsChildChildNode;

        return rightChildNode;
    }

    private TreapNode rightRotate(TreapNode node) {
        TreapNode leftChildNode = node.left;
        TreapNode leftsChildChildNode = leftChildNode.right;

        leftChildNode.right = node;
        node.left = leftsChildChildNode;

        return leftChildNode;
    }

    public void insert(K key, P priority, V value) {
        root = insert(key, priority, value, root);
    }

    private TreapNode insert(K key, P priority, V value, TreapNode parent) {
        if (parent == null) {
            return new TreapNode(key, priority, value);
        }

        if (key.compareTo(parent.key) > 0) {
            parent.right = insert(key, priority, value, parent.right);

            if (parent.right.priority.compareTo(parent.priority) < 0) {
                parent = leftRotate(parent);
            }
        } else {
            parent.left = insert(key, priority, value, parent.left);

            if (parent.left.priority.compareTo(parent.priority) < 0) {
                parent = rightRotate(parent);
            }
        }
        return parent;
    }

    public int findHeight() {
        return findHeight(root);
    }

    private int findHeight(TreapNode node) {
        if (node == null) return 0;
        return 1 + max(findHeight(node.left), findHeight(node.right));
    }

    public V delete(K key) {
        if (isEmpty()) {
            return null;
        }

        Tuple<TreapNode, V> deleted = delete(key, getRoot());
        root = deleted.getFirst();
        return deleted.getSecond();
    }

    private Tuple<TreapNode, V> delete(K key, TreapNode node) {
        if (node == null) {
            return new Tuple<>(null, null);
        }
        V value = null;

        if (key.compareTo(node.key) < 0) {
            Tuple<TreapNode, V> tempToDel = delete(key, node.left);
            node.left = tempToDel.getFirst();
            value = tempToDel.getSecond();
        } else if (key.compareTo(node.key) > 0) {
            Tuple<TreapNode, V> tempToDel = delete(key, node.right);
            node.right = tempToDel.getFirst();
            value = tempToDel.getSecond();
        } else {
            value = node.getValue();
            if (node.left == null) {
                //hodí pravého potomka jako předka
                node = node.right;
            } else if (node.right == null) {
                //ddto pro levého
                node = node.left;
            } else if (node.left.priority.compareTo(node.right.priority) > 0) {
                node = leftRotate(node);
                node.left = delete(key, node.left).getFirst();
            } else {
                node = rightRotate(node);
                node.right = delete(key, node.right).getFirst();
            }
        }
        return new Tuple<>(node, value);
    }

    public Iterator<Tuple<TreapNode, Integer>> levelOrderIterator() {
        Iterator<Tuple<TreapNode, Integer>> iterator = new Iterator() {

            Queue<Tuple<TreapNode, Integer>> queue = new LinkedList<>();

            {
                queue.add(new Tuple<>(getRoot(), 0));
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Tuple<TreapNode, Integer> next() {
                Tuple<TreapNode, Integer> current = queue.poll();
                TreapNode currentNode = current.getFirst();
                if (currentNode.left != null) {
                    queue.add(new Tuple<>(currentNode.left, current.getSecond() + 1));
                }
                if (currentNode.right != null) {
                    queue.add(new Tuple<>(currentNode.right, current.getSecond() + 1));
                }
                return current;
            }
        };
        return iterator;
    }

    public TreapNode getRoot() {
        return root;
    }

    public void clean() {
        root = null;
    }
}
