package ua.com.alevel.DAO;

import ua.com.alevel.entity.User;

public interface UserDAO {
    void add(User user);
    void delete(String login);
    void delete(int number);
    void update(User user);
    User getByLogin(String login);
    User[] getAll();
}
