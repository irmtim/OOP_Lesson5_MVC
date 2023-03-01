package personal.controllers;

import personal.model.Repository;
import personal.model.User;
import personal.model.ValidateUser;

import java.util.List;

public class UserController {
    private final Repository repository;

    private ValidateUser validateUser = new ValidateUser();

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) throws Exception {
        validateUser.check(user);
        repository.CreateUser(user);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        throw new Exception("User not found");
    }

    public List<User> readUsersList(){
        List<User> users = repository.getAllUsers();
        return users;
    }

    public void deleteUser(String userID){
        repository.deleteUserFromRepository(userID);
    }

    public void updateUser(User user){
        repository.updateUserInList(user);
    }
}
