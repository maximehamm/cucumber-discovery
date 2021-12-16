package org.maxime.cucumber;

public class Book {

   public String title;
   public Author author;
   public Integer year;

    public Book(String title, Author author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
