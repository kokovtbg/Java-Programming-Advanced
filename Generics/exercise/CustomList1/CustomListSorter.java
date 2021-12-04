package Generics.exercise.CustomList1;

public class CustomListSorter {

    public static void methodSort(CustomList list) {
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).toString().compareTo(list.get(i + 1).toString()) > 0) {
                    list.swap(i, i + 1);
                }
            }
        }
    }
}
