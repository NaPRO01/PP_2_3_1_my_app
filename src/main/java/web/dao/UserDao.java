package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    List<User> index();

    User show(long id);

    void saveUser(User user);

    void update(long id, User user);

    void delete(long id);

}
