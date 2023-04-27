package ua.goit.sergey.modul9;

public class MyQueue<T> {

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

    public void add(Object value) {
        Node<T> newNode = new Node<T>((T) value);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (first == null)return null;
        else return (T) first.element;
    }

    public T poll() {
        T removeElement;
        if (first == null) return null;
        else {
            removeElement = first.element;
            first = first.next;
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
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size-1; i ++){
            res.append(getNodeByIndex(i).element+ ", ");
        }
        res.append(getNodeByIndex(size-1).element);
        return "" + res + "";
    }
}