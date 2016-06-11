package dao.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import dao.MessageDAO;
import dao.mapper.MessageMapper;
import model.Message;

/**
 * @author salamar
 *
 */
public class MessageDAOImpl extends AbstractDAO implements MessageDAO {

	@Override
	public List<Message> listAllMessages(Integer groupId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();

		String query = "SELECT * " + " FROM " + MessageMapper.tableName;

		if (groupId != null) {
			query += " WHERE " + MessageMapper.Column.GROUP_ID.getName() + " = :groupId";
			parameters.addValue("groupId", groupId);
		}

		return namedParameterJdbcTemplate.query(query, parameters, new MessageMapper());
	}
}
