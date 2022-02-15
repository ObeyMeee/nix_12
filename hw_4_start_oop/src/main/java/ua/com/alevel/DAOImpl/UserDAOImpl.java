package ua.com.alevel.DAOImpl;

import ua.com.alevel.DAO.UserDAO;
import ua.com.alevel.entity.User;

public class UserDAOImpl implements UserDAO {
    private User[] users = new User[0];
    @Override
    public void add(User user) {
        User[] tempUsers = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            tempUsers[i] = users[i];
        }
        tempUsers[tempUsers.length - 1] = user;
        users = tempUsers;

    }

    @Override
    public void delete(String login) {
        for (int i = 0; i < users.length; i++) {
            if(users[i].login().equals(login)){
                delete(i + 1);
                break;
            }
        }
    }

    @Override
    public void delete(int number) {
        User[] tempUsers = new User[users.length - 1];
        for (int i = 0; i < number - 1; i++) {
            tempUsers[i] = users[i];
        }

        for (int i = number - 1; i < tempUsers.length; i++) {
            tempUsers[i] = users[i + 1];
        }
        users = tempUsers;
    }

    @Override
    public void update(User user) {
        for (int i = 0; i < users.length; i++) {
            if(users[i].id().equals(user.id())){
                users[i] = user;
                break;
            }
        }
    }

    @Override
    public User getByLogin(String login) {
        for (User user : users) {
            if (user.login().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User[] getAll() {
        return users;
    }
}
