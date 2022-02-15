package ua.com.alevel.service;

import ua.com.alevel.DAO.UserDAO;
import ua.com.alevel.config.DBConfig;
import ua.com.alevel.entity.User;

public class UserService {
    UserDAO userDAO = DBConfig.getInstance().getUserDAO();

   public void add(User user){
        userDAO.add(user);
    }
    public void delete(String login){
        userDAO.delete(login);
    }
    public void delete(int number){
        userDAO.delete(number);
    }
    public void update(User user){
        userDAO.update(user);
    }
    public User getByLogin(String login){
        return userDAO.getByLogin(login);
    }
    public User[] getAll(){
        return userDAO.getAll();
    }
}
