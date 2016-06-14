package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Group;
import model.Group.Status;

/**
 * @author salamar
 *
 */
public class GroupMapper implements RowMapper<Group> {

    public static final String tableName = "groups";

    public enum Column {
        //please use names and not numbers in your SQL. Numbers here are for your reference only.
        //Always crawl through from lowest number to the highest one
        GROUP_ID(1, "groupId"),
        NAME(2,"name"),
        DESCRIPTION(3, "description"),
        STATUS(4, "status"),
        INSERT_TIMESTAMP(5, "insertTimestamp");
    	

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

    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Please iterate according to column order in the database. Please make sure that column order in enum here matches the order in our db.
    	Integer groupId = rs.getInt(Column.GROUP_ID.getName());
    	String name = rs.getString(Column.NAME.getName());
    	String description = rs.getString(Column.DESCRIPTION.getName());
        Status status = Status.getStatus(rs.getInt(Column.STATUS.getName()));
    	// TODO read also the timestamp
    	
    	Group group = new Group(groupId, name, description, status, null);
        return group;
    }

}
