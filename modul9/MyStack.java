package ua.goit.sergey.modul9;

import java.util.Objects;

public class MyStack<T>{

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
                last = prev;}

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

    public T peek() {
        if (first == null)return null;
        else return (T) last.element;
    }

    public T pop() {
        T removeElement;
        if (last == null) return null;
        else if (size > 1){
            Node<T> prev = getNodeByIndex(size - 2);
            removeElement = (T) last.element;
            last = prev;
        }
        else{
            removeElement = (T) last.element;
            last = first = null;
        }
        size--;
        return (T) removeElement;
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
        try {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size-1; i ++){
            res.append(getNodeByIndex(i).element+ ", ");
        }
        res.append(getNodeByIndex(size-1).element);
        return "" + res + "";
        } catch (NullPointerException e){
            return "null";
        }
    }
}