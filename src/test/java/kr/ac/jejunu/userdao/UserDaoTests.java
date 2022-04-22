package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao(new JejuConnectionMaker());
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        String name = "hulk";
        String password = "1234";
        User user = new User();

        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new UserDao(new JejuConnectionMaker());
        userDao.insert(user);

        assertThat(user.getId(), greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(user.getName(), is(insertedUser.getName()));
        assertThat(user.getPassword(), is(insertedUser.getPassword()));
    }
    @Test
    public void testGetForHalla() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao(new HallaConnectionMaker());
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insertForHalla() throws SQLException, ClassNotFoundException {
        String name = "hulk";
        String password = "1234";
        User user = new User();

        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new UserDao(new HallaConnectionMaker());
        userDao.insert(user);

        assertThat(user.getId(), greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(user.getName(), is(insertedUser.getName()));
        assertThat(user.getPassword(), is(insertedUser.getPassword()));
    }
}