package org.example;

import java.io.File;

public class LibraryProcess{


    public LibraryProcess(){
        String path = "C:\\Users\\bodan\\IdeaProjects\\Library\\library-core\\src\\main\\resources\\";
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


        LibraryUI libraryUI = new LibraryUI();

        libraryUI.run();
    }


}