package Generics.exercise.CustomList1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int index1, int index2) {
        T firstElement = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, firstElement);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getClass().getName().substring(list.get(i).getClass().getName().lastIndexOf(".") + 1).equals("String")) {
                if (list.get(i).toString().compareTo(element.toString()) > 0) {
                    count++;
                }
            }
//            if (list.get(i).getClass().getName().substring(list.get(i).getClass().getName().lastIndexOf(".") + 1).equals("Integer")) {
//                if (Integer.parseInt(list.get(i).toString()) > Integer.parseInt(element.toString())) {
//                    count++;
//                }
//            }
//            if (list.get(i).getClass().getName().substring(list.get(i).getClass().getName().lastIndexOf(".") + 1).equals("Double")) {
//                if (Double.parseDouble(list.get(i).toString()) > Double.parseDouble(element.toString())) {
//                    count++;
//                }
//            }
        }
        return count;
    }

    public T getMax() {
        return Collections.max(list);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getClass().getName().substring(list.get(i).getClass().getName().lastIndexOf(".") + 1).equals("String")) {
//            }
//        }
    }

    public T getMin() {
        return Collections.min(list);
    }

    public int size() {
        return list.size();
    }

    public T get(int index) {
        return list.get(index);
    }
}
