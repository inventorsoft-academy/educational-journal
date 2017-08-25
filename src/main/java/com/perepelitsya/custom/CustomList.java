package com.perepelitsya.custom;

import java.util.*;
import java.util.Arrays;

/**
 * Created by Andriu on 8/22/2017.
 */
public class CustomList< E extends Comparable<E>> implements List<E> {

    //size of mylist
    private int size = 0;

    //default capasity
    private static final int DEFAULT_CAPACITY = 16;

    //my array
    private Object[] list = null;

    //default constructor with capasity = 16
    public CustomList() {
        list = new Object[DEFAULT_CAPACITY];
    }

    //constructor with your capacity. need to fix it
    public CustomList(int capacity) {
        list = new Object[capacity];
    }


    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //check if size == max value of list(16), you need to  grow up your list
    @Override
    public boolean add(E e) {
        if (size == list.length) {
            ensureCapa();
        }
        list[size++] = e;
        return true;
    }


    private void ensureCapa() {
        int newSize = list.length * 2;
        list = Arrays.copyOf(list, newSize);
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(list, size);
    }

    @Override
    public E get(int index) {
        if (index >= list.length) {
            System.out.println("Your element find");
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);

        }
        return (E) list[index];
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public E set(int index, E element) {
        E elem = null;
        if(index>=list.length){
            elem = (E) (list[index] = element);
        }
        return elem;
    }

    public void sortToMax(){
        Arrays.sort(list, 0, size);

    }

    @Override
    public void add(int index, E element) {

    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }


    @Override
    public E remove(int index) {
        return null;
    }


    @Override
    public boolean contains(Object o) {
        return o.equals(o.getClass());
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
