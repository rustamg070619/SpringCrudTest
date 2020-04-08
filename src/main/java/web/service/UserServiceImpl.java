package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public User getUserByLogin(String login) {
        try {
            return userDao.getUserByLogin(login);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
