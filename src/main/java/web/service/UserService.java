package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    List<User> index();

    Object show(long id);

    void saveUser(User user);

    void update(long id, User user);

    void delete(long id);

}
