package com.types;

public class MyStack<T> {
    private Node<T> top;
    private int size;

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    public T top() {
        return top.getValue();
    }
    public void push(T value) {
        this.top = new Node<>(value, this.top);
        this.size++;
    }

    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Empty Stack");
        }
        T ret = top.getValue();
        this.top = this.top.getNext();
        this.size--;
        return ret;
    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<T> tmp = top;
        String ret = "--\n";
        while (tmp != null) {
            ret += tmp.getValue() + "\n";
            tmp = tmp.getNext();
        }
        return ret + "--";
    }
}
