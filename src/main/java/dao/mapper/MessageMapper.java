package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Group;
import model.Message;
import model.Message.Status;

/**
 * @author salamar
 *
 */
public class MessageMapper implements RowMapper<Message> {

	public static final String tableName = "messages";

    public enum Column {
        //please use names and not numbers in your SQL. Numbers here are for your reference only.
        //Always crawl through from lowest number to the highest one
		MSG_ID(1, "msgId"), PARENT_MSG_ID(2, "parentMsgId"), GROUP_ID(3, "groupId"), CONTENT(4, "content"), LIKES_CNT(5,
				"likesCnt"), STATUS(6, "status"), INSERT_TIMESTAMP(7, "insertTimestamp");
    	

        private int position;
        private String name;

        private Column(int position, String name) {
            this.position = position;
            this.name = name;
        }

        public int getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }
    }

	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Please iterate according to column order in the database. Please make sure that column order in enum here matches the order in our db.
		Integer msgId = rs.getInt(Column.MSG_ID.getName());
		Integer parentMsgId = rs.getInt(Column.PARENT_MSG_ID.getName());
		Group group = new Group(rs.getInt(Column.GROUP_ID.getName()));
		String content = rs.getString(Column.CONTENT.getName());
		Integer likesCnt = rs.getInt(Column.LIKES_CNT.getName());
        Status status = Status.getStatus(rs.getInt(Column.STATUS.getName()));
    	// TODO read also the timestamp
    	
		Message message = new Message(msgId, parentMsgId, group, content, likesCnt, status, null);
		return message;
    }

}
