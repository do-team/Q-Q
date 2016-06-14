package dao.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

    @Override
    public Boolean insertNewMessage(Message message, DateTime now) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

        // @formatter:off
        String query = 
                "INSERT INTO " + MessageMapper.tableName
                + "(" + MessageMapper.Column.PARENT_MSG_ID.getName()
                + ", " + MessageMapper.Column.GROUP_ID.getName()
                + ", " + MessageMapper.Column.CONTENT.getName()
                + ", " + MessageMapper.Column.LIKES_CNT.getName()
                + ", " + MessageMapper.Column.STATUS.getName()
                + ", " + MessageMapper.Column.INSERT_TIMESTAMP.getName()
                + ")"
                + " VALUES (:parentMsgId, :groupId, :content, :likesCnt, :status, :insertTimestamp)";
        // @formatter:on
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("parentMsgId", message.getParentMsgId());
        params.addValue("groupId", message.getGroup().getGroupId());
        params.addValue("content", message.getContent());
        params.addValue("likesCnt", message.getLikesCnt());
        params.addValue("status", message.getStatus().getValue());
        params.addValue("insertTimestamp", fmt.print(now));

        namedParameterJdbcTemplate.update(query, params);
        return Boolean.TRUE;
    }
}
