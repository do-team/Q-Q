package dao.impl;

import java.util.List;

import dao.GroupDAO;
import dao.mapper.GroupMapper;
import model.Group;

/**
 * @author salamar
 *
 */
public class GroupDAOImpl extends AbstractDAO implements GroupDAO {

	@Override
	public List<Group> listAllGroups() {
		String query = "SELECT * " + " FROM " + GroupMapper.tableName;
		return templateObject.query(query, new GroupMapper());
	}
}
