package com.types;

public class BST {
    private BSTNode root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public void insert(int value) {
        this.root = insertHelp(this.root, value);
        this.size++;
    }

    private BSTNode insertHelp(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value, null, null);
        } else if (value < root.getValue()) {
            root.setLeft(insertHelp(root.getLeft(), value));
        } else {
            root.setRight(insertHelp(root.getRight(), value));
        }
        return root;

    }

    public void clear() {
        this.root = null;
        this.size = 0;
    }

    public boolean contains(int value) {
        return containsHelp(this.root, value);
    }

    private boolean containsHelp(BSTNode root, int value) {
        if (root == null)
            return false;
        else if (root.getValue() == value)
            return true;
        else
            return containsHelp(root.getLeft(), value) || containsHelp(root.getRight(), value);
    }

    private BSTNode getMin(BSTNode root) {
        if (root.getLeft() == null) return root;
        return getMin(root.getLeft());
    }

    private BSTNode deleteMin(BSTNode root) {
        if (root.getLeft() == null) return root.getRight();
        root.setLeft(deleteMin(root.getLeft()));
        return root;

    }

    public void remove(int value) {
        if (this.contains(value)) {
            this.root = removeHelp(this.root, value);
            this.size--;
        }
    }

    private BSTNode removeHelp(BSTNode root, int value) {
        if (root == null) return null;
        if (value < root.getValue()) {
            root.setLeft(removeHelp(root.getLeft(), value));
        } else if ( value > root.getValue()) {
            root.setRight(removeHelp(root.getRight(), value));
        } else {
            if (root.getLeft() == null) return root.getRight();
            else if (root.getRight() == null) return root.getLeft();
            else {
                BSTNode tmp = getMin(root.getRight());
                root.setValue(tmp.getValue());
                root.setRight(deleteMin(root.getRight()));
            }
        }
        return root;
    }

    public int size() {
        return this.size;
    }

    public void inOrder() {
        inOrderHelp(this.root);
        System.out.println();
    }

    private void inOrderHelp(BSTNode root) {
        if (root != null) {
            inOrderHelp(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderHelp(root.getRight());
        }
    }
}
