package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user, Long id) {
        Query query = entityManager.createQuery("update User u set u.age = :age, u.name = :name, u.email = :email where u.id = :id");
        query.setParameter("age", user.getAge() );
        query.setParameter("name", user.getName() );
        query.setParameter("email", user.getEmail() );
        query.setParameter("id", id );

        query.executeUpdate();
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("delete from User u where u.id = :id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
