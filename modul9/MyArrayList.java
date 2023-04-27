package ua.goit.sergey.modul9;

import java.util.Objects;
import java.util.StringJoiner;

public class MyArrayList<E>{
    
    private static final int SIZE= 10;
    private Object[] data;
    private int index;

    public MyArrayList(){
        data = new Object [SIZE];
    }

    public void add (E value){
        resize();
        data[index] = value;
        index++;
    }

    public void add(int index, E value){
        if ( 0 <= index && index < getIndex()){
        resize();
        int numMoved = size()-index;
        int newSize = size()+1;
        System.arraycopy(data, index , data, index+1, numMoved);
        data[index] = value;
        setIndex(newSize);
        }else{
            System.out.println("Не коректный индекс, запись не добавлена.");
        }
    }

    private void resize(){
        if (index == data.length){
            int newSize = data.length+10;
            Object [] newData = new Object[newSize];
            System.arraycopy(data, 0, newData,0, data.length);
            data = newData;
        }
    }

    public  Object remove(int index){
        Objects.checkIndex(index, size());
        int numMoved = size()-index;
        int newSize = size()-1;
        System.arraycopy(data, index +1, data, index, numMoved);
        setIndex(newSize);
        return data;
    }

    public int clear(){
        return index = 0;
    }

    public int size(){
        return index;
    }

    public E get (int index){
        Objects.checkIndex(index, size());
        return (E) data[index];
    }

    private void setIndex(int index) {
        this.index = index;
    }

    private int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        StringJoiner res = new StringJoiner(", ");
        for (int i = 0; i < index; i ++){
            res.add((CharSequence) data[i]);
        }
        return "[" + res + "]";
    }
}