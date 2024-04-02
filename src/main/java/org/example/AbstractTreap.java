package org.example;

import java.util.Iterator;

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

    public AbstractTreap() {
        this.root = new TreapNode();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TreapNode leftRotate(TreapNode node) {
        TreapNode rightChildNode = node.right;
        TreapNode rightsChildChildNode = rightChildNode.left;

        rightChildNode.left = node;
        node.right = rightsChildChildNode;

        return rightChildNode;
    }

    public TreapNode rightRotate(TreapNode node) {
        TreapNode leftChildNode = node.left;
        TreapNode leftsChildChildNode = leftChildNode.right;

        leftChildNode.right = node;
        node.left = leftsChildChildNode;

        return leftChildNode;
    }

    public TreapNode insert(K key, TreapNode newNode) {
        if (isEmpty()) {
            return new TreapNode(key, null, newNode.getValue());
        }

        if (key.compareTo(newNode.key) <= 0) {
            newNode.left = insert(key, newNode.left);

            if (newNode.left.priority.compareTo(newNode.priority) > 0) {
                newNode = rightRotate(newNode);
            }
        } else {
            newNode.right = insert(key, newNode.right);

            if (newNode.right.priority.compareTo(newNode.priority) > 0) {
                newNode = leftRotate(newNode);
            }
        }
        return newNode;
    }

    public TreapNode deleteNode(K key, TreapNode node) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = deleteNode(key, node.left);
        } else if (key.compareTo(node.key) > 0) {
            node.right = deleteNode(key, node.right);
        } else if (node.left == null) {
            //hodí pravého potomka jako kořen
            TreapNode temp = node.right;
            node = temp;
        } else if (node.left.priority.compareTo(node.right.priority) < 0) {
            node = leftRotate(node);
            node.left = deleteNode(key, node.left);
        } else {
            node = rightRotate(node);
            node.right = deleteNode(key, node.right);
        }
        return node;
    }

}
