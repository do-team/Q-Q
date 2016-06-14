package service;

import java.util.List;

import model.Group;

public interface GroupService {

	List<Group> listAllGroups();

    public Boolean insertNewGroup(Group group);
}
