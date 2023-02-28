package personal.views;

import personal.controllers.UserController;
import personal.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                    if (com == Commands.EXIT) return;
                    switch (com) {
                        case CREATE:
                            caseCreateUser();
                            break;
                        case READ:
                            caseReadUser();
                            break;
                        case LIST:
                            // выводит список юзеров
                            caseReadListUsers();
                            break;
                        case DELETE:
                            caseUserDelete();
                            break;
                        case UPDATE:

                }
            } catch (Exception e) {
                System.out.printf("%sПроизошла ошибка\n", e.getMessage());;
            }
        }
    }

    private void caseUserDelete() {
        String id = prompt("Введите ИД пользователя для удаления: ");
        userController.deleteUser(id);
        System.out.println("Был удален пользователь с ИД " + id);
    }

    private void caseReadListUsers() {
        List<User> users = userController.readUsersList();
        for (User item : users
             ) {
            System.out.println(item);
        }
    }

    private void caseReadUser() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User user = userController.readUser(id);
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void caseCreateUser() throws Exception {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        userController.saveUser(new User(firstName, lastName, phone));
        return;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

     
}
