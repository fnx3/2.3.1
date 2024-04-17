package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    User get(Long id);
    List<User> getAll();

    void add(User user);

    void update(User user, Long id);
    void delete(Long id);

}
