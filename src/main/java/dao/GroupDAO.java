package dao;

import java.util.List;

import org.joda.time.DateTime;

import model.Group;

/**
 * @author salamar
 *
 */
public interface GroupDAO {

    List<Group> listAllGroups();

    public Boolean insertNewGroup(Group group, DateTime now);
}
