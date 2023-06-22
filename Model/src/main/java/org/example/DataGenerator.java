package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public List<User> getUsers(int n, User temp){

        List<User> users = new ArrayList<>();
        for(int i = 0; i < n; i++){
            users.add(new User(temp.getClass().getSimpleName() + "Name" + i, encryptPassword(temp.getClass().getSimpleName() + "Password" + i)));
        }

        return users;
    }

    private  String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
