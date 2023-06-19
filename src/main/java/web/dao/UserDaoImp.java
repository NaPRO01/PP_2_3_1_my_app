package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImp() {}

    @Override
    public List<User> index() {
        return entityManager.createQuery(
                "select u from User u", User.class).getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User user) {
        User updateUser = show(id);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        entityManager.merge(updateUser);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
