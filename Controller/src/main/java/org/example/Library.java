package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, String> readers = new HashMap<>();
    private Map<String, String> librarians = new HashMap<>();
    private Map<String, String> managers = new HashMap<>();





    public Library() {
        ;

    }

    public void addBook(Book book) {
        books.add(book);

    }

    public void  readFileForBooks(String path){
        Gson gson = new Gson();
        String filePath = path + "books.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Book[] booksArray = gson.fromJson(reader, Book[].class);
            books = Arrays.asList(booksArray);


        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні JSON-файлу: " + e.getMessage());
        }

    }

    public void readFileForUsers(User user, String path){
        String filePath = path + user.getClass().getSimpleName() + ".txt" ;

        try (FileReader reader = new FileReader(filePath)) {
            // Створення об'єкту Gson
            Gson gson = new Gson();

            // Визначення типу даних
            Type type = new TypeToken<List<Map<String, String>>>() {}.getType();

            // Зчитування даних з JSON-файлу в список об'єктів
            List<Map<String, String>> data = gson.fromJson(reader, type);

            // Створення HashMap для зберігання даних
            Map<String, String> userDataMap = new HashMap<>();

            // Заповнення HashMap зчитаними даними
            for (Map<String, String> obj : data) {
                String userName = obj.get("userName");
                String password = obj.get("password");
                userDataMap.put(userName, password);
            }






            if(user.getClass().getSimpleName().equals("Manager")){
                /*for (Map<String, String> map : data) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        managers.put(key,value);
                    }
                }*/
                managers = userDataMap;
            }
            else if (user.getClass().getSimpleName().equals("Librarian") ) {
                /*for (Map<String, String> map : data) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        librarians.put(key,value);
                    }
                }*/
                librarians = userDataMap;
            }
            else if (user.getClass().getSimpleName().equals("Reader")) {
                /*for (Map<String, String> map : data) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        readers.put(key,value);
                    }
                }*/
                readers = userDataMap;
            }


            // Виведення даних з HashMap
            /*for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                readers.put(key,value)
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        return books;
    }
    public Map<String, String> getReaders() {
        return readers;
    }
    public Map<String, String> getLibrarians() { return librarians;}
    public Map<String, String> getManagers() {
        return managers;
    }

    // Інші методи та логіка
}