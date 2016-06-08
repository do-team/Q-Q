package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import model.User;

/**
 * @author salamar
 *
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    @Override
    public List<User> listAllUsers() {
        /*String query = "SELECT " + UserMapper.Column.USER_ID.getName()
                + " FROM " + UserMapper.tableName;
        List<User> result = templateObject.query(query, new UserMapper());

        return result;
        */
        return new ArrayList<User>();
    }
}
