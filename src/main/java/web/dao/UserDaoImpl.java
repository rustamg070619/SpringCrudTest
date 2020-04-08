package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) throws IndexOutOfBoundsException {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("from User WHERE login= :loginParam")
                .setParameter("loginParam", login).list().get(0);
        return user;

    }
}
