package IteratorsComparatos.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    private void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public int compareTo(Book book) {
        if (this.getTitle().compareTo(book.getTitle()) == 0){
            if (this.getYear() > book.getYear()) {
                return 1;
            } else if (this.getYear() < book.getYear()) {
                return -1;
            }
            return 0;
        } else {
            return this.getTitle().compareTo(book.getTitle());
        }
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
