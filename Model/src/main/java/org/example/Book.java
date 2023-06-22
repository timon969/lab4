package org.example;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String newTitle){
        title = newTitle;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String newAuthor){
        author = newAuthor;
    }


    // Інші методи та логіка
}