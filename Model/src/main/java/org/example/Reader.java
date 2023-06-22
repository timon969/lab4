package org.example;

import java.util.ArrayList;
import java.util.List;

public class Reader extends User{
    private List<Book> booksToRead = new ArrayList<>();


    public Reader(String userName, String password) {
        super(userName, password);
    }
}
