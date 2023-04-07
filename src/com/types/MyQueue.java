package com.types;

public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyQueue() {
        this.first = this.last = null;
        this.size = 0;
    }

    public void enqueue(T value) {
        if (this.size == 0) {
            this.first = this.last = new Node<T>(value, null);
            this.size++;
            return;
        }
        this.last.setNext(new Node<T>(value, null));
        this.last = this.last.getNext();
        this.size++;
    }

    public T dequeue() throws Exception {
        if (this.size == 0)
            throw new Exception("Empty Queue");
        T ret = this.first.getValue();
        this.first = this.first.getNext();
        this.size--;
        return ret;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String ret = "";
        Node<T> tmp = this.first;
        while (tmp != null) {
            ret += tmp.getValue() + " ";
            tmp = tmp.getNext();
        }
        return ret;
    }

}
