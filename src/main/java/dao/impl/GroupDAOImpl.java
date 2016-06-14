package dao.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

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

    @Override
    public Boolean insertNewGroup(Group group, DateTime now) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

        // @formatter:off
        String query = 
                "INSERT INTO " + GroupMapper.tableName
                + "(" + GroupMapper.Column.NAME.getName()
                + ", " + GroupMapper.Column.DESCRIPTION.getName()
                + ", " + GroupMapper.Column.STATUS.getName()
                + ", " + GroupMapper.Column.INSERT_TIMESTAMP.getName()
                + ")"
                + " VALUES (:name, :description, :status, :insertTimestamp)";
        // @formatter:on
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", group.getName());
        params.addValue("description", group.getDescription());
        params.addValue("status", group.getStatus().getValue());
        params.addValue("insertTimestamp", fmt.print(now));

        namedParameterJdbcTemplate.update(query, params);
        return Boolean.TRUE;
    }

}
