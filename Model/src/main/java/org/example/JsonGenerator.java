package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonGenerator<Type> {

    private Type temp;

    public JsonGenerator(Type t){
        temp = t;
    }

    public static void createFileForBooks() {

        // Створюємо список книг
        List<Book> books = new ArrayList<>();

        for(int i = 1; i < 1000; i++){
            books.add(new Book("Book " + i, "Author " + i));
        }

        File file = new File("C:\\Users\\bodan\\IdeaProjects\\Library_gradle\\Model\\src\\main\\resources\\books.txt");

        if (file.exists()) {
            System.out.println("Файл вже існує.");
        } else {
            try {
                file.createNewFile();

                // Створюємо об'єкт ObjectMapper для серіалізації в JSON
                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    // Конвертуємо список книг в JSON рядок
                    String json = objectMapper.writeValueAsString(books);

                    // Записуємо JSON рядок у файл
                    objectMapper.writeValue(file, books);

                    System.out.println("Файл books.json створено успішно!");
                } catch (IOException e) {
                    System.out.println("Помилка при генерації файлу JSON: " + e.getMessage());
                }
            } catch (IOException e) {
                System.out.println("Сталася помилка при створенні файлу: " + e.getMessage());
            }
        }



    }
    public void createFileForUser(List<Type> users) {


        File file = new File("C:\\Users\\bodan\\IdeaProjects\\Library_gradle\\Model\\src\\main\\resources\\" + temp.getClass().getSimpleName() + ".txt" );

        if (file.exists()) {
            System.out.println("Файл вже існує.");
        } else {
            writeFileInJsonFormat(file,users);
        }



    }

    private void writeFileInJsonFormat(File file, List<Type> users ){
        try {
            file.createNewFile();

            // Створюємо об'єкт ObjectMapper для серіалізації в JSON
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                // Конвертуємо список читачів в JSON рядок
                String json = objectMapper.writeValueAsString(users);

                // Записуємо JSON рядок у файл
                objectMapper.writeValue(file, users);

                System.out.println("Файл json створено успішно!");
            } catch (IOException e) {
                System.out.println("Помилка при генерації файлу JSON: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка при створенні файлу: " + e.getMessage());
        }
    }

}