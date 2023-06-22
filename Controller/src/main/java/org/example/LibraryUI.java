package org.example;


import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class LibraryUI {
    private Library library;
    Scanner scanner = new Scanner(System.in);

    public LibraryUI() {

        library = new Library();

        String path = "C:\\Users\\bodan\\IdeaProjects\\Library_gradle\\Model\\src\\main\\resources\\";
        JsonGenerator.createFileForBooks();

        DataGenerator dataGenerator = new DataGenerator();

        File file = new File(path + "Manager.txt");
        if(!file.exists()){
            JsonGenerator<User> jsonGeneratorForManagers = new JsonGenerator<>(new Manager("temp","temp"));
            jsonGeneratorForManagers.createFileForUser(dataGenerator.getUsers(10,new Manager("temp","temp")));

        }

        file = new File(path + "Reader.txt");

        if(!file.exists()){
            JsonGenerator<User> jsonGeneratorForReaders = new JsonGenerator<>(new Reader("temp","temp"));
            jsonGeneratorForReaders.createFileForUser(dataGenerator.getUsers(1000,new Reader("temp","temp")));

        }

        file = new File(path + "Librarian.txt");
        if(!file.exists()){
            JsonGenerator<User> jsonGeneratorForReaders = new JsonGenerator<>(new Librarian("temp","temp"));
            jsonGeneratorForReaders.createFileForUser(dataGenerator.getUsers(10,new Librarian("temp","temp")));

        }

        library.readFileForUsers(new Manager("temp", "temp"), path );
        library.readFileForUsers(new Reader("temp", "temp"), path);
        library.readFileForUsers(new Librarian("temp", "temp"), path);
        library.readFileForBooks(path);
    }

    public void run() {

        chooseUser();
    }


    public void displayBooks() {
        System.out.println("books: ");
        for (Book book : library.getBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void displayReaders() {
        System.out.println("reader: ");
        for (String password : library.getReaders().values()) {

            System.out.println(password + "\n");
        }
    }

    private void chooseUser(){


        System.out.println("Виберіть в який кабінет ввійти: \n" +
                "1. Читач \n" +
                "2. Бібліотекар \n" +
                "3. Менеджер \n" +
                "4. Вийти з системи");

        String choose = scanner.nextLine();

        if(choose.equals("1")){
            logInUserName(library.getReaders(), choose);

        } else if (choose.equals("2")) {
            logInUserName(library.getLibrarians(), choose);
        }

        else if(choose.equals("3")){
            logInUserName(library.getManagers(),choose);
        }
        else if(choose.equals("4")){
            System.out.println("Гарного дня");
        }
        else {
            System.out.println("Повторіть спробу");
            chooseUser();
        }


    }



    private void logInUserName(Map<String, String> users, String choose) {
        System.out.println("Введіть свій userName або -1 якщо хочете повернутись до попереднього меню: \n");

        String userName = scanner.nextLine();

        if(users.containsKey(userName)){

            logInPassword(users, userName, choose);

        }
        else if (userName.equals("-1")) {
            chooseUser();
        } else  {
            System.out.println("Введеного userName не існує, повторіть спробу");
            logInUserName(users,choose);
        }


    }

    private void logInPassword(Map<String, String> users, String userName,  String choose) {

        System.out.println("Введіть свій password або -1 якщо хочете повернутись до попереднього меню: \n");

        String password = scanner.nextLine();

        if (BCrypt.checkpw(password, users.get(userName))){
            if(choose.equals("1")){
                menuForReader();
            }
            else if (choose.equals("2")) {
                menuForLibrarian();
            }
            else{
                menuForManager();
            }


        } else if (password.equals("-1")){
            logInUserName(users,choose);
        }
        else {
            System.out.println("Не правильний пароль, повторіть спробу");
            logInPassword(users, userName,choose);
        }
    }

    private void menuForManager() {
        System.out.println("Виберіть дію: \n" +
                "1. Додати бібліотекаря \n" +
                "2. Видати бібліотекаря \n" +
                "3. Вийти з кабінету \n");
        String choose = scanner.nextLine();

        if (choose.equals("1")){

        } else if (choose.equals("2")) {

        }
        else if (choose.equals("3")) {
            chooseUser();
        }
        else {
            System.out.println("Повторіть спробу");
            menuForManager();
        }

    }

    private void menuForLibrarian() {
        System.out.println("Виберіть дію: \n" +
                "1. Додати читача \n" +
                "2. Видати читача \n" +
                "3. Вийти з кабінету \n");

        String choose = scanner.nextLine();

        if (choose.equals("1")){

        } else if (choose.equals("2")) {

        }
        else if (choose.equals("3")) {
            chooseUser();
        }
        else {
            System.out.println("Повторіть спробу");
            menuForLibrarian();
        }
    }

    private void menuForReader() {
        System.out.println("Виберіть дію: \n" +
                "1. Переглянути всі книги \n" +
                "2. Вибрати Книгу \n" +
                "3. Вийти з кабінету \n");

        String choose = scanner.nextLine();

        if (choose.equals("1")){

        } else if (choose.equals("2")) {

        }
        else if (choose.equals("3")) {
            chooseUser();
        }
        else {
            System.out.println("Повторіть спробу");
            menuForReader();
        }
    }

    // Інші методи та логіка
}