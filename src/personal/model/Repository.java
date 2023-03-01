package personal.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String CreateUser(User user);

    void deleteUserFromRepository(String userId);

    void updateUserInList(User user);
}
