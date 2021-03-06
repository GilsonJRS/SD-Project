/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Database;
import java.io.IOException;
import java.util.List;
import model.User;

/**
 *
 * @author gilson
 */
public class UserDAO {
    public void save(User user) throws IOException{
        Database db = Database.getInstance();
        db.getUsers().add(user);
        db.saveState();
    }
    
    public List<User> select() throws IOException{
        Database db = Database.getInstance();
        return db.getUsers();
    }
    
    public List<User> selectAll() throws IOException{
        Database db = Database.getInstance();
        return (List<User>)db.getUsers();
    }
    
    public void delete(User user) throws IOException{
        Database db = Database.getInstance();
        db.getUsers().remove(user);
        db.saveState();
    }
    
    public boolean update(User user) throws IOException{
        Database db = Database.getInstance();
        int index = db.getUsers().indexOf(user);
        if(index == -1){
            return false;
        }
        db.getUsers().set(index, user);
        db.saveState();
        return true;
    }
    
    public boolean updateById(User user) throws IOException{
        Database db = Database.getInstance();
        List<User> users = db.getUsers();
        int index=-1;
        String id = user.getId();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId().equals(id)){
                index = i;
            }
        }
        if(index == -1){
            return false;
        }
        db.getUsers().set(index, user);
        db.saveState();
        return true;
    }
}
