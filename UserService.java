package com.samytech.socialapi.user;

import com.samytech.socialapi.location.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    User user1 = new User(
            "u1",
            "Sam",
            "Idowu",
            new Location("l1", "Lagos"),
            "sammy@gmail.com");
    User user2 = new User(
            "u2",
            "Hannah",
            "Arinola",
            new Location("l2", "Lagos"),
            "arinola@gmail.com");
        List<User> users = new ArrayList<>(Arrays.asList(user1, user2));

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(String id){
        User user = users.stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return user;
    }


    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(String id, User user) {
        for (int index = 0; index < users.size(); index++){
            User update = users.get(index);
            if (update.getId().equals(id)){
                users.set(index, user);
            }
        }
    }

    public void deleteUser(String id) {
        users.removeIf(use -> use.getId().equals(id));
    }
}
