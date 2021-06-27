package org.iocollections.utils;

import java.util.ArrayList;

public class SortedList<T extends Comparable<T>> extends ArrayList<T> {

    @Override
    public boolean add(T t) {

        if (isEmpty())
            super.add(t);
        else {
            int lastIndex = size() - 1;

            if (t.compareTo(get(lastIndex)) < 0) {
                add(lastIndex, t);
            } else if (t.compareTo(get(lastIndex)) > 0) {
                super.add(t);
            }
        }
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index == 0) {
            super.add(index, element);
        } else {
            int prevIndex = index - 1;
            if (element.compareTo(get(prevIndex)) < 0) {
                add(prevIndex, element);
            } else if (element.compareTo(get(prevIndex)) >= 0) {
                super.add(index, element);
            }
        }
    }

    public static void main(String[] args) {
        SortedList<Integer> integers = new SortedList<>();
        integers.add(56);
        integers.add(34);
        integers.add(45);
        integers.add(12);
        integers.add(25);
        integers.add(30);

        for (int a : integers) {
            System.out.println(a);
        }
    }
}
