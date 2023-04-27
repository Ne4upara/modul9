package ua.goit.sergey.modul9;

import java.util.Objects;

public class MyLinkedList<T> {

    static class Node<T> {
        T element;
        Node<T> next;
        private Node (T element){
            this.element = element;
        }
    }

    private Node<T> last;
    private Node<T> first;
    private int size;


    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removeElement;
        if (index == 0) {
            removeElement = first.element;
            first = first.next;
            if (first == null) last = null;
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removeElement = prev.next.element;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
        return removeElement;
    }

    public void clear(){
        first = last = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size-1; i ++){
            res.append(getNodeByIndex(i).element+ ", ");
        }
        res.append(getNodeByIndex(size-1).element);
        return "" + res + "";
    }
}
